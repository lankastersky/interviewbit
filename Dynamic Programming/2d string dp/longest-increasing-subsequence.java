/*
Longest Increasing Subsequence

Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

https://www.interviewbit.com/problems/longest-increasing-subsequence/
*/

public class Solution {
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        if (A == null) {
            return 0;
        }
        int memo[] = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            memo[i] = -1;
        }
        
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, lis(A, i, memo));
        }
        
        return max;
    }
    
     int lis(List<Integer> A, int cur, int[] memo) {
         if (cur == A.size()) {
             return 0;
         }
         if (memo[cur] != -1) {
             return memo[cur];
         }
         
         int result = 1;
         int el = A.get(cur);
         for (int i = cur + 1; i < A.size(); i++) {
             if (el < A.get(i)) {
                 result = Math.max(result, 1 + lis(A, i, memo));
             }
         }
         
         memo[cur] = result;
         return result;
    }
}
