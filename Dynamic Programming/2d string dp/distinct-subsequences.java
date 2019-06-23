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
    int N;
    int M;
    public int numDistinct(String A, String B) {
        N = A.length();
        M = B.length();
        int m[][] = new int[N][];
        for (int i = 0; i < N; i++) {
            m[i] = new int[M];
            for (int j = 0; j < M; j++) {
                m[i][j] = -1;
            }
        }
        
        return ds(A, B, 0, 0, m);
    }
    
    int ds(String A, String B, int a, int b, int m[][]) {
        if (b == M) {
            return 1;
        }
        if (a == N) {
            return 0;
        }
        if (m[a][b] != -1) {
            return m[a][b];
        }
        int res = 0;
        for (int i = a; i < N; i++) {
            if (A.charAt(i) == B.charAt(b)) {
                res += ds(A, B, i + 1, b + 1, m);
            }
        }
        m[a][b] = res;
        return res;
    }
}
