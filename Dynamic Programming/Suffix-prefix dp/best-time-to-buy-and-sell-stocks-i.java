/*
Best Time to Buy and Sell Stocks I

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1


https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        long min = A.get(0);
        long profit = 0;
        for (int i = 1; i < A.size(); i++) {
            if ( profit < A.get(i) - min) {
                profit = A.get(i) - min;
            }
            if (A.get(i) < min) {
                min = A.get(i);
            }
        }
        return (int) profit;
    }
}
