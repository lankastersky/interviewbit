/*
N digit numbers with digit sum S

Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

**

N = 2, S = 4 
Valid numbers are {22, 31, 13, 40} 
Hence output 4.

https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
*/

public class Solution {

    static final int MOD = 1000000007;
    int memo[][]; 
    
    public int solve(int N, int S) {
        memo = new int[N + 1][];
        for (int i = 0; i < N + 1; i++) {
            memo[i] = new int[S + 1];
            for (int j = 0; j < S + 1; j++) {
                memo[i][j] = -1;
            }
        }
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            if (S - i >= 0) {
                res = (res + solveImpl(N - 1, S - i)) % MOD;
            }
        }
        return res;
    }
    
    int solveImpl(int N, int S) {
        if (N < 0 || S < 0) {
            return 0;
        }

        if (N == 0) {
            return S == 0 ? 1 : 0;
        }
        
        if (S == 0) {
            return 1;
        }

        if (memo[N][S] != -1) {
            return memo[N][S];
        }
        
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            if (S - i >= 0) {
                res = (res + solveImpl(N - 1, S - i)) % MOD;
            }
        }

        memo[N][S] = res;
        return res;
    }
}
