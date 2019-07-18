/*
Distinct Subsequences

Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

 Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). 
Example :

S = "rabbbit" 
T = "rabbit"
Return 3. And the formations as follows:

S1= "ra_bbit" 
S2= "rab_bit" 
S3="rabb_it"
"_" marks the removed character.

https://www.interviewbit.com/problems/distinct-subsequences/
*/

public class Solution {

        /**
         * Solution (DP):
         * We keep a m*n matrix and scanning through string S, while
         * m = T.length() + 1 and n = S.length() + 1
         * and each cell in matrix Path[i][j] means the number of distinct subsequences of 
         * T.substr(1...i) in S(1...j)
         * 
         * Path[i][j] = Path[i][j-1]            (discard S[j])
         *              +     Path[i-1][j-1]    (S[j] == T[i] and we are going to use S[j])
         *                 or 0                 (S[j] != T[i] so we could not use S[j])
         * while Path[0][j] = 1 and Path[i][0] = 0.
         */
         public int numDistinct(String S, String T) {
        int N = S.length();
        int M = T.length();
        if (N < M) {
            return 0;
        }
        int m[][] = new int[N + 1][M + 1];
        m[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            m[i][0] = 1; // if T is "", the only way is just remove all symbols from S
            for (int j = 1; j <= M; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1] + m[i - 1][j];
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }

        // Same solution, just another looping order
        // for (int i = 0; i <= N; i++) {
        //     m[i][0] = 1; // if T is "", the only way is just remove all symbols from S
        // }

        // for (int j = 1; j <= M; j++) {
        //     for (int i = 1; i <= N; i++) {
        //         if (S.charAt(i - 1) == T.charAt(j - 1)) {
        //             m[i][j] = m[i - 1][j - 1] + m[i - 1][j];
        //         } else {
        //             m[i][j] = m[i - 1][j];
        //         }
        //     }
        // }

        return m[N][M];
    }
    
    // Working solution using recursion
    // int N;
    // int M;
    // public int numDistinct(String A, String B) {
    //     N = A.length();
    //     M = B.length();
    //     int m[][] = new int[N][];
    //     for (int i = 0; i < N; i++) {
    //         m[i] = new int[M];
    //         for (int j = 0; j < M; j++) {
    //             m[i][j] = -1;
    //         }
    //     }
        
    //     return ds(A, B, 0, 0, m);
    // }
    
    // int ds(String A, String B, int a, int b, int m[][]) {
    //     if (b == M) {
    //         return 1;
    //     }
    //     if (a == N) {
    //         return 0;
    //     }
    //     if (m[a][b] != -1) {
    //         return m[a][b];
    //     }
    //     int res = 0;
    //     for (int i = a; i < N; i++) {
    //         if (A.charAt(i) == B.charAt(b)) {
    //             res += ds(A, B, i + 1, b + 1, m);
    //         }
    //     }
    //     m[a][b] = res;
    //     return res;
    // }
}
