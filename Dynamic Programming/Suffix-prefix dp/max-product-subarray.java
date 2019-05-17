/*
Max Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6 

Possible with [2, 3]

https://www.interviewbit.com/problems/max-product-subarray/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    long NEG_INF = Long.MIN_VALUE;
    long INF = Long.MAX_VALUE;
    public int maxProduct(final List<Integer> A) {
        int n = A.size();
        long max = NEG_INF;
        long min = INF;
        long neg = 0;
        long pos = 0;
        // check  -3 3 3 0 1
        for (int i = 0; i < n; i++) {
            int el = A.get(i);
            if (el == 0) {
                neg = 0;
                pos = 0;
            } else if (el > 0) {
                if (pos == 0) {
                    pos = el;
                } else {
                    pos *= el;
                }
                neg *= el;
            } else {
                long tneg = neg;
                if (pos != 0) {
                    neg = pos * el;
                } else {
                    neg = el;
                }
                pos = tneg * el;
            }
            max = Math.max(max, pos);
            min = Math.min(min, neg);
        }
        return (int) max;
        
        // Doesn't work for zeros in the middle, e.g. -4 0 -5 0
        // int n = A.size();
        // long dp[] = new long[n + 1];
        // dp[0] = 1;
        // for (int i = 0; i < n; i++) {
        //     if (A.get(i) == 0) {
        //         continue;
        //     }
        //     if (dp[i] == 0) {
        //         dp[i + 1] = A.get(i);
        //     } else {
        //         dp[i + 1] = dp[i] * A.get(i);
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     print(dp[i + 1]);
        // }
        // println("");
        // long res = A.get(0);
        // for (int i = 0; i < n; i++) {
        //     if (dp[i + 1] == 0) {
        //         res = Math.max(res, 0);
        //         continue;
        //     }
        //     for (int j = i; j < n; j++) {
        //         if (dp[i + 1] == 0) {
        //             break;
        //         }
        //         if (i == j) {
        //             res = Math.max(res, A.get(i));
        //             continue;
        //         }
        //         res = Math.max(res, dp[j + 1] / dp[i + 1]);
        //     }
        // }
        // return (int) res;
        
        
        // Doesn't work for negative numbers, e.g. 1 3 0 -3 -2
        // int res = A.get(0);
        // int cur = 1;
        // for (int a: A) {
        //     cur = Math.max(a, cur * a);
        //     res = Math.max(res, cur);
        // }
        // return res;
    }
    
    void print(long i) {
        System.out.print(i + " ");
    }
    
    void println(String i) {
        System.out.println(i + "");
    }
}
