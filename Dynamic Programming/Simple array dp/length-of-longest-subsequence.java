/*
Length of Longest Subsequence

Problem Setter: mayank111 Problem Tester: glowing_glare
Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6

https://www.interviewbit.com/problems/length-of-longest-subsequence/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        if (n <= 2) {
            return n;
        }
        int inc[] = new int[n];
        int dec[] = new int[n];

        inc[0] = 1;
        for (int i = 1; i < n ; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i)) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0 ; i--) {
            dec[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (A.get(j) < A.get(i)) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // for (int j = 0; j < n; j++) {
        //     System.out.print(inc[j] + " ");
        // }
        // System.out.println();
        // for (int j = 0; j < n; j++) {
        //     System.out.print(dec[j] + " ");
        // }
        // System.out.println();
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, inc[i] + dec[i] - 1);
        }
        return res;
    }
}
