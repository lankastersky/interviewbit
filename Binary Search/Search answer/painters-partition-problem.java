/*
Painter's Partition Problem
Asked in:  
Google
Codenation
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much
time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that
any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
Example

Input : 
  K : 2
  T : 5
  L : [1, 10]
Output : 50

https://www.interviewbit.com/problems/painters-partition-problem/
*/

  public class Solution {
    int MOD = 10000003;

    boolean isPossible(int K, ArrayList<Integer> C, long time) {
      int N = C.size();
      long workers = 1;
      long sum = 0;
      for (int i = 0; i < N; i++) {
        int c = C.get(i);
        if (c > time) {
          return false;
        }
        if (sum + c > time) {
          sum = c;
          workers++;
        } else {
          sum += c;
        }
        if (workers > K) {
          return false;
        }
      }
      return true;
    }

    public int paint(int K, int T, ArrayList<Integer> C) {
      long sum = 0;
      for (int c: C) {
        sum += c;
      }
      long low = 0;
      long high = sum;
      long result = Long.MAX_VALUE;
      while (low <= high) {
        long time = low + (high - low) / 2;
        if (isPossible(K, C, time)) {
          result = Math.min(result, time);
          high = time - 1;
        } else {
          low = time + 1;
        }
        println(String.format("l,h,x: %d,%d, %d", low, high, result));
      }
      return (int) ( ((result % MOD) * (T % MOD)) % MOD );
    }

    void println(String s) {
      //System.out.println(s);
    }
  }
