/*
Best Time to Buy and Sell Stocks III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation : 
  Day 1 : Buy 
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
  
https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if (n <= 1) {
            return 0;
        }
        
        //int k = 2;
        // int[][] profit = new int[k][n]; 
  
        // Gives TLE.
        // Based on 
        // https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
        // for (int j = 1; j < n; j++) { 
        //     int max_so_far = 0; 
        //     for (int m = 0; m < j; m++) {
        //         max_so_far = Math.max(max_so_far, A.get(j) - A.get(m)); 
        //     } 
        //     profit[0][j] = Math.max(profit[0][j - 1], max_so_far); 
        // } 
  
        // for (int i = 1; i < k; i++) { 
        //     for (int j = 1; j < n; j++) { 
        //         int max_so_far = 0; 
        //         for (int m = 0; m < j; m++) 
        //             max_so_far = Math.max(max_so_far, A.get(j) - 
        //                      A.get(m) + profit[i - 1][m]); 
  
        //         profit[i][j] = Math.max(profit[i][j - 1], max_so_far); 
        //     }
        // }
  
        // Based on 
        // https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
        // for (int i = 1; i <= k; i++) { 
        //     int prevDiff = Integer.MIN_VALUE;
        //     for (int j = 1; j < n; j++) {
        //         prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - A.get(j - 1));
        //         profit[i][j] = Math.max(profit[i][j - 1], A.get(j) + prevDiff);
        //     }
        // }

        // return profit[k][n - 1];
        

        // Another solution
        // int fb = Integer.MIN_VALUE;
        // int fs = 0;
        // int sb = Integer.MIN_VALUE;
        // int ss = 0;
        // for (int a: A) {
        //     fb = Math.max(fb, -a);      // first buy
        //     fs = Math.max(fs, fb + a);  // first buy, first sell
        //     sb = Math.max(sb, fs - a);  // 2 buys
        //     ss = Math.max(ss, sb + a);  // 2 sells
        // }
        // return ss;
        
        
        // And another solution
        int left[] = new int[n];
        int right[] = new int[n];
        int cur = A.get(0);
        for (int i = 1; i < n; i++) {
            cur = Math.min(cur, A.get(i));
            left[i] = Math.max(left[i - 1], A.get(i) - cur);
        }
        cur = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            cur = Math.max(cur, A.get(i));
            right[i] = Math.max(right[i + 1], cur - A.get(i));
        }
        int res = 0;
        
        // now for each day i we have two transactions: [0..i] and [i..n]
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + right[i]);
        }
        return res;
    }

}
