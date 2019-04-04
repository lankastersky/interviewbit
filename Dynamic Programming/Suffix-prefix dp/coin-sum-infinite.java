/*
Coin Sum Infinite

You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

Example :

Input : 
	S = [1, 2, 3] 
	N = 4

Return : 4

Explanation : The 4 possible ways are
{1, 1, 1, 1}
{1, 1, 2}
{2, 2}
{1, 3}	
Note that the answer can overflow. So, give us the answer % 1000007

https://www.interviewbit.com/problems/coin-sum-infinite/
*/

public class Solution {
    int base = 1000007;

    public int coinchange2(ArrayList<Integer> S, int N) {
        if (S.size() == 0) {
            return 0;
        }
        //Collections.sort(S);
        int[] memo = new int[N + 1];
        memo[0] = 1;
        for (int s: S) {
            int temp = 0;
            for (int n = 1; n <= N; n++) {
                if (n - s >= 0) {
                    memo[n] = (memo[n] + memo[n - s]) % base;
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            print(i + ":" + memo[i]);
        }
        return memo[N];
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }

    // Gives OOM.
    // int[][] memo;
    // ArrayList<Integer> S;
    // public int coinchange2(ArrayList<Integer> Sin, int N) {
    //     if (Sin.size() == 0 || N == 0) {
    //         return 0;
    //     }
    //     S = Sin;
    //     Collections.sort(S);
    //     memo = new int[N + 1][];
    //     for (int i = 0; i <= N; i++) {
    //         memo[i] = new int[N + 1];
    //         for (int j = 0; j <= N; j++) {
    //             memo[i][j] = -1;
    //         }
    //     }
    //     return rec(N, 0);
    // }
    
    // int rec(int N, int start) {
    //     if (N == 0) {
    //         return 1;
    //     }
    //     if (N < 0) {
    //         return 0;
    //     }
    //     if (memo[N][start] != -1) {
    //         return memo[N][start];
    //     }
    //     int res = 0;
    //     for (int i = start; i < S.size(); i++) {
    //         int s = S.get(i);
    //         res = (res + rec(N - s, i)) % base; 
    //     }
    //     memo[N][start] = res;
    //     return res;
    // }
}
