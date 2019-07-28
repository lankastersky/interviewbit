/*
Best Time to Buy and Sell Stocks II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 3]
Return : 2

https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int min = A.get(0);
        long profit = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > min) {
                profit = profit + (A.get(i) - min);
            }
            min = A.get(i);
        }
        return (int) profit;
    }
}
