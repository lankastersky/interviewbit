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
    Map<String, Integer> memo = new HashMap<>();
    static final int MOD = 1000000007;
    
    public int solve(int N, int S) {
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
        
        String key = String.format("%d_%d", N, S);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            if (S - i >= 0) {
                res = (res + solveImpl(N - 1, S - i)) % MOD;
            }
        }
        memo.put(key, res);
        return res;
    }
}
