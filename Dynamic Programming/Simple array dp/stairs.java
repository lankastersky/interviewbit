/*
Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]

https://www.interviewbit.com/problems/stairs/
*/

public class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int A) {
        if (A <= 1) {
            return 1;
        }
        if (memo.containsKey(A)) {
            return memo.get(A);
        }
        int result = climbStairs(A - 1) + climbStairs(A - 2);
        memo.put(A, result);
        return result;
    }
}
