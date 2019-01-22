/*
Max Sum Without Adjacent Elements

Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8

https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
*/

public class Solution {

    ArrayList<ArrayList<Integer>> A;
    int memo[];
    int m = 2;
    int n;
    
    public int adjacent(ArrayList<ArrayList<Integer>> a) {
        A = a;
        if (A == null || A.size() < 2 || A.get(0).isEmpty()) {
            return 0;
        }
        if (A.get(0).size() != A.get(1).size()) {
            return 0;
        }
        n = A.get(0).size();
        memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        return solve(0);
    }
    
    int solve(int cur) {
        if (cur >= n) {
            return 0;
        }
        if (cur < memo.length && memo[cur] != -1) {
            return memo[cur];
        }
        int res = 0;
        for (int i = cur; i < n; i++) {
            int up = A.get(0).get(i);
            int down = A.get(1).get(i);
            int temp = solve(i + 2);
            res = Math.max(res, up + temp);
            res = Math.max(res, down + temp);
            res = Math.max(res, up);
            res = Math.max(res, down);
        }
        memo[cur] = res;
        return res;
    }
}
