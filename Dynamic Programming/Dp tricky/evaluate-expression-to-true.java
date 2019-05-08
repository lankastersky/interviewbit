/*
Evaluate Expression To True

Given expression with operands and operators (OR , AND , XOR) , in how many ways can you evaluate the expression to true, 
by grouping in different ways? Operands are only true and false.
Input:

string :  T|F&T^T
here '|' will represent or operator 
     '&' will represent and operator
     '^' will represent xor operator
     'T' will represent true operand
     'F' will false
Output:

different ways % MOD
where MOD = 1003
Example:

string : T|F
only 1 way (T|F) => T
so output will be 1 % MOD = 1

https://www.interviewbit.com/problems/evaluate-expression-to-true/
*/

public class Solution {
    char T = 'T';
    char F = 'F';
    int base = 1003;
    // left - right - flag (tru/false)
    int dp[][][];
    
    public int cnttrue(String A) {
        int n = A.length();
        dp = new int[n][][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[n][];
            for (int j = 0; j < n; j++) {
                dp[i][j] = new int[2];
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return cnt(A, 0, n - 1, true);
    }
    
    int cnt(String A, int left, int right, boolean flag) {
        if (left == right) {
            char c = A.charAt(left);
            if ((c == T && flag) || (c == F && !flag)) {
                return 1;
            }
            return 0;
        }
        int f = flag ? 1 : 0;
        if (dp[left][right][f] != -1) {
            return dp[left][right][f];
        }
        long res = 0;
        for (int i = left + 1; i <= right; i += 2) {
            char c = A.charAt(i); // operand
            int leftTrue = cnt(A, left, i - 1, true);
            int leftFalse = cnt(A, left, i - 1, false);
            int rightTrue = cnt(A, i + 1, right, true);
            int rightFalse = cnt(A, i + 1, right, false);
            switch (c) {
                case '|':
                    if (flag) {
                        // (leftTrue * rightTrue) + (leftFalse * rightTrue) + (leftTrue * rightFalse)
                        long tmp = ((long) leftTrue * rightTrue) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftFalse * rightTrue) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftTrue * rightFalse) % base;
                        res = (res + tmp) % base;
                    } else {
                        // (leftFalse * rightFalse)
                        long tmp = ((long) leftFalse * rightFalse) % base;
                        res = (res + tmp) % base;
                    }
                    break;
                case '&':
                    if (flag) {
                        // (leftTrue * rightTrue)
                        long tmp = ((long) leftTrue * rightTrue) % base;
                        res = (res + tmp) % base;
                    } else {
                        // (leftFalse * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightFalse)
                        long tmp = ((long) leftFalse * rightFalse) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftFalse * rightTrue) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftTrue * rightFalse) % base;
                        res = (res + tmp) % base;
                    }
                    break;
                case '^':
                    if (flag) {
                        // (leftTrue * rightFalse) + (leftFalse * rightTrue)
                        long tmp = ((long) leftTrue * rightFalse) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftFalse * rightTrue) % base;
                        res = (res + tmp) % base;
                    } else {
                        // (leftFalse * rightFalse) + (leftTrue * rightTrue)
                        long tmp = ((long) leftFalse * rightFalse) % base;
                        res = (res + tmp) % base;
                        tmp = ((long) leftTrue * rightTrue) % base;
                        res = (res + tmp) % base;
                    }
                    break;
            }
        }
        dp[left][right][f] = (int) res;
        return (int) res;
    }
}
