/*
Regular Expression Match

Implement wildcard pattern matching with support for '?' and '*'.

'?' : Matches any single character.
'*' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

The function prototype should be:

int isMatch(const char *s, const char *p)
Examples :

isMatch("aa","a") → 0
isMatch("aa","aa") → 1
isMatch("aaa","aa") → 0
isMatch("aa", "*") → 1
isMatch("aa", "a*") → 1
isMatch("ab", "?*") → 1
isMatch("aab", "c*a*b") → 0
Return 1/0 for this problem.

https://www.interviewbit.com/problems/regular-expression-match/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    int M;
    int N;
    char NULL = 2;
    public int isMatch(final String A, final String B) {
        M = A.length();
        N = B.length();
        char memo[][] = new char[M + 1][];
        for (int i = 0; i <= M; i++) {
            memo[i] = new char[N];
            for (int j = 0; j < N; j++) {
                memo[i][j] = NULL;
            }
        }
        return (int) rem(A, B, 0, 0, memo);
    }
    
    
    char rem(String A, String B, int a, int b, char memo[][]) {
        if (a == M && b == N) {
            return 1;
        }
        if (b >= N) {
            return 0;
        }
        if (memo[a][b] != NULL) {
            return memo[a][b];
        }
        char res = 0;
        char ch = B.charAt(b);
        int nexta = Math.min(a + 1, M);
        switch (ch) {
            case '*':
                if (a < M && rem(A, B, nexta, b, memo) == 1) {
                    return 1;
                }
                if (rem(A, B, a, b + 1, memo) == 1) { // * stands for empty string
                    return 1;
                }
                res = rem(A, B, nexta, b + 1, memo); // * stands for one char
                break;
            case '?':
                if (a >= M) {
                    break;
                }
                res = rem(A, B, a + 1, b + 1, memo);
                break;
            default:
                if (a >= M) {
                    break;
                }
                if (A.charAt(a) == ch) {
                    res = rem(A, B, a + 1, b + 1, memo);
                }
                break;
        }
        memo[a][b] = res;
        return res;
    }
}
