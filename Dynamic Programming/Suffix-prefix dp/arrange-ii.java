/*
Arrange II

You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses
into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into
stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products.
This value should be the minimum among all possible accommodation arrangements.

Example:

Input: {WWWB} , K = 2
Output: 0

Explanation:

We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option. 

If a solution is not possible, then return -1.

https://www.interviewbit.com/problems/arrange-ii/
*/

    public class Solution {
        
        public int arrange(String A, int K) {
            int n = A.length();
            if (n < K) {
                return -1;
            }            
            int dp[][] = new int[K][n];
            for (int i = 0; i < K; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            int res = ar(A, K, 0, 0, dp);
            return res == Integer.MAX_VALUE ? -1 : res;
        }
        
        int ar(String A, int K, int s, int h, int dp[][]) {
            int n = A.length();
            if (s == K && h == n) {
                return 0;
            }
            if (s == K || h == n) {
                return Integer.MAX_VALUE;
            }
            if (dp[s][h] != -1) {
                return dp[s][h];
            }
            int res = Integer.MAX_VALUE;
            int w = 0;
            int b = 0;
            for (int i = h; i < n; i++) {
                char c = A.charAt(i);
                if (c == 'W') {
                    w++;
                } else {
                    b++;
                }
                int temp = ar(A, K, s + 1, i + 1, dp); 
                if (temp != Integer.MAX_VALUE) {
                    res = Math.min(res, w * b + temp);
                }
            }
            dp[s][h] = res;
            return res;
        }
        
        // see https://github.com/isopropylcyanide/InterviewBit-DP/blob/master/arange.java
        // public int arrange(String A, int K) {
        //     int n = A.length();
        //     if (n < K) {
        //         return -1;
        //     }            
        //     int dp[][] = new int[K + 1][n + 1];

        //     for (int h = 1; h <= n; h++) { // available horses
        //         dp[1][h] = product(A, 0, h - 1);
        //     }
        //     for (int s = 2; s <= K; s++) {  // stables
        //         for (int h = s; h <= n; h++) { // available horses
        //             int min = Integer.MAX_VALUE;
        //             for (int i = s - 1; i <= h - 1; i++) { // horses parked in current stable
        //                 min = Math.min(min, dp[s - 1][i] + product(A, i, h - 1));
        //             }
        //             dp[s][h] = min;
        //         }
        //     }
        //     return dp[K][n];

        // }

        // int product(String A, int s, int e) {
        //     int w = 0;
        //     int b = 0;
        //     for (int i = s; i <= e; i++) {
        //         char c = A.charAt(i);
        //         if (c == 'W') {
        //             w++;
        //         } else {
        //             b++;
        //         }
        //     }
        //     return w * b;
        // }
    }
