/*
Flip Array

Given an array of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible). Return the minimum no. of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

Constraints:

 1 <= n <= 100
Sum of all the elements will not exceed 10,000.

Example:

A = [15, 10, 6]
ans = 1 (Here, we will flip the sign of 15 and the resultant sum will be 1 )

A = [14, 10, 4]
ans = 1 (Here, we will flip the sign of 14 and the resultant sum will be 0)

 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there are not minimum
 
https://www.interviewbit.com/problems/flip-array/
*/

  public class Solution {
    // num n of available elements - sum W -> approached sum
    int[][] memo;
    int[] cum;
    // n_W - indices from memo
    Map<String, Set<Integer>> map = new HashMap<>();
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
      int n = A.size();
      if (n == 0) {
        return 0;
      }
      cum = new int[n + 1];
      cum[0] = 0;
      for (int i = 1; i <= n; i++) {
        cum[i] = cum[i - 1] + A.get(i - 1);
      }
      memo = new int[n + 1][];
      int W = cum[n] / 2;
      for (int i = 0; i <= n; i++) {
        memo[i] = new int[W + 1];
        for (int j = 0; j <= W; j++) {
          memo[i][j] = -1;
        }
      }

      rec(n, W, A);

      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= W; j++) {
          print(String.valueOf(memo[i][j]));
        }
        println("");
      }

      for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= W; j++) {
          String key = String.format("%d_%d", i, j);
          Set<Integer> set = map.get(key);
          if (set == null)
            continue;
          print(key + ": ");
          for (int el: set)
            print(String.valueOf(A.get(el)));
          println("");
        }
        println("");
      }

      String key = String.format("%d_%d", n, W);
      Set<Integer> set = map.get(key);
      //return Math.min(set.size(), n - set.size());
      return set.size();
    }

    // Based on https://en.wikipedia.org/wiki/Knapsack_problem#0/1_knapsack_problem
    int rec(int i, int j, List<Integer> A) {
      if (i == 0 || cum[i] <= 0) {
        return 0;
      }
      if (memo[i - 1][j] == -1) {
        memo[i - 1][j] = rec(i - 1, j, A);
      }
      int w = A.get(i - 1);
      String key = String.format("%d_%d", i, j);
      if (w > j) {
        memo[i][j] = memo[i - 1][j];
        String prevKey = String.format("%d_%d", i - 1, j);
        map.put(key, map.get(prevKey));
      } else {
        if (memo[i - 1][j - w] == -1) {
          memo[i - 1][j - w] = rec(i - 1, j - w, A);
        }
        int wItem = memo[i - 1][j - w] + w;
        String wKey = String.format("%d_%d", i - 1, j - w);
        Set<Integer> wSet = map.get(wKey);
        int wnum = wSet == null ? 1 : wSet.size();

        String prevKey = String.format("%d_%d", i - 1, j);
        Set<Integer> prevSet = map.get(prevKey);
        int prevnum = prevSet == null ? 0 : prevSet.size();
        if (wItem > memo[i - 1][j] || (wItem == memo[i - 1][j] && (wnum < prevnum)) ) {
          memo[i][j] = wItem;
          Set<Integer> set;
          if (wSet == null) {
            set = new HashSet<>();
          } else {
            set = new HashSet<>(wSet);
          }
          set.add(i - 1);
          map.put(key, set);
        } else {
          memo[i][j] = memo[i - 1][j];
          map.put(key, prevSet);
        }
      }
      return memo[i][j];
    }

    void print(String s) {
      //System.out.print(s + " ");
    }

    void println(String s) {
      //System.out.println(s);
    }
  }
