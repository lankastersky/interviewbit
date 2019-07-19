/*
Regular Expression II

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Some examples:

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "a*") → 1
isMatch("aa", ".*") → 1
isMatch("ab", ".*") → 1
isMatch("aab", "c*a*b") → 1
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/regular-expression-ii/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        int N = A.length();
        int M = B.length();
        int dp[][] = new int[N][M];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return reg(A, B, 0, 0, dp);
    }
    
    int reg(String A, String B, int a, int b, int dp[][]) {
        int N = A.length();
        int M = B.length();
        if (a == N && b == M) {
            return 1;
        }
        if (a == N || b == M) {
            return 0;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        }
        int res = 0;
        char ca = A.charAt(a);
        char cb = B.charAt(b);
        if (b + 1 < M && B.charAt(b + 1) == '*') {
            if (reg(A, B, a, b + 2, dp) == 1) { // * stands for empty string
                res = 1;
            } else if (ca == cb || cb == '.') {
                res = reg(A, B, a + 1, b + 2, dp); // * stands for one symbol
                if (res != 1) {
                    res = reg(A, B, a + 1, b, dp);
                }
            }
        } else {
            switch (cb) {
                case '.':
                    res = reg(A, B, a + 1, b + 1, dp);
                    break;
                default:
                    if (ca == cb) {
                        res = reg(A, B, a + 1, b + 1, dp);
                    }
                    break;
            }
        }
        dp[a][b] = res;
        return res;
    }
}
