/*
Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

https://www.interviewbit.com/problems/combinations/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n * k <= 0) {
            return res;
        }
        if (n < k) {
            return res;
        }
        rec(new ArrayList<>(), k, n, 1, res);
        return res;
    }
    
    void rec(ArrayList<Integer> cur, int k, int n, int low,
      ArrayList<ArrayList<Integer>> res) {
      
      if (cur.size() == k) {
          res.add(new ArrayList<>(cur));
          return;
      }
      for (int i = low; i <= n; i++) {
          cur.add(i);
          rec(cur, k, n, i + 1, res);
          cur.remove(cur.size() - 1);
      }
    }
}

