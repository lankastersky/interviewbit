/*
Interleaving Strings

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/interleaving-strings/
*/

public class Solution {
    int L;
    int M;
    int N;
    public int isInterleave(String A, String B, String C) {
        L = A.length();
        M = B.length();
        N = C.length();
        int memo[][][] = new int[L + 1][][];
        for (int i = 0; i <= L; i++) {
            memo[i] = new int [M + 1][];
            for (int j = 0; j <= M; j++) {
                memo[i][j] = new int [N + 1];
                for (int k = 0; k <= N; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return is(A, B, C, 0, 0, 0, memo);
    }
    
    int is(String A, String B, String C, int a, int b, int c, int memo[][][]) {
        if (a == L && b == M && c == N) {
            return 1;
        }
        if ((a == L && b == M) || c == N) {
            return 0;
        }
        if (memo[a][b][c] != -1) {
            return memo[a][b][c];
        }
        int res = 0;
        char ch = C.charAt(c);
        if (a < L && A.charAt(a) == ch) {
            if (is(A, B, C, a + 1, b, c + 1, memo) == 1) {
                return 1;
            }
        }
        if (b < M && B.charAt(b) == ch) {
            if (is(A, B, C, a, b + 1, c + 1, memo) == 1) {
                return 1;
            }
        }
        memo[a][b][c] = res;
        return res;
    }
}
