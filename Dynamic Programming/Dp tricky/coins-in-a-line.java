/*
Coins in a Line

There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6

https://www.interviewbit.com/problems/coins-in-a-line/
*/

public class Solution {
    Map<String, Integer> memo = new HashMap<>();
    

    public int maxcoin(ArrayList<Integer> A) {
        return maxcoin(A, 0, A.size() - 1, true);
    }

    int maxcoin(ArrayList<Integer> A, int left, int right, boolean turn) {
        if (left > right) {
            return 0;
        }
        String key = String.format("%d_%d_%s", left, right, String.valueOf(turn));
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int leftResult = maxcoin(A, left + 1, right, !turn);
        int rightResult = maxcoin(A, left, right - 1, !turn);
        int result;
        if (turn) {
            // maximize money
            result = Math.max(leftResult + A.get(left), 
              rightResult + A.get(right));
        } else {
            // minimize money
            result = Math.min(leftResult, rightResult);
        }
        memo.put(key, result);
        return result;
    }
}
