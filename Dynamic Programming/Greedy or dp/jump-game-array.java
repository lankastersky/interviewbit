/*
Jump Game Array

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem

https://www.interviewbit.com/problems/jump-game-array/
*/

public class Solution {
    public int canJump(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        boolean reachable[] = new boolean[A.size()];
        reachable[0] = true;
        int i = 0; // next reachable index
        while (i < A.size() && reachable[i]) {
            int el = A.get(i);
            for (int j = 1; j <= el && i + j < A.size(); j++) {
                reachable[i + j] = true;
            }
            i++;
        }
        return reachable[A.size() - 1] ? 1 : 0;
    }
}
