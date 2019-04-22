/*
Power of 2

Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1

https://www.interviewbit.com/problems/power-of-2/
*/

public class Solution {
    char ZERO = '0';

    public int power(String A) {
        int n = A.length();
        if (n == 0) {
            return 0;
        }
        if (A.equals("0") || A.equals("1")) {
            return 0;
        }
        while (true) {
            n = A.length();
            if (A.equals("1")) {
                return 1;
            }
            int d = A.charAt(n - 1) - ZERO;
            if (d % 2 != 0) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for (int i = 0; i < n; i++) {
                d = A.charAt(i) - ZERO;
                d += add;
                if (d < 2) {
                    add = d * 10;
                    if (i > 0) {
                        sb.append(0);
                    }
                    continue;
                }
                char c = (char) (d / 2 + ZERO);
                sb.append(c);
                add = (d % 2) * 10;
            }
            println(sb.toString());
            A = sb.toString();
        }
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
