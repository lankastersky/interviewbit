/*
Atoi

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 

https://www.interviewbit.com/problems/atoi/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int atoi(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (c == '0' &&
                    (sb.length() == 0 || (sb.length() == 1 && sb.charAt(0) == '-'))
                )  { // ignore leading zero
                    continue;
                }
                sb.append(c);
            } else if (i == 0) {
                if (c == '-') {
                    sb.append(c);
                } else if (c == '+') {
                    continue;
                } else if (c == ' ') {
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        String a = sb.toString();
        n = a.length();
        //System.out.println("a:" + a);
        
        if (n == 0) {
            return 0;
        }
        if (n == 1 && a.charAt(0) == '-') {
            return 0;
        }
        long mul = sign(a);
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = a.charAt(i);
            if (c >= '0' && c <= '9') {
                long d = c - '0';
                res = res + d * mul;
                mul *= 10;
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int) res;
    }
    
    int sign(String s) {
        if (s.charAt(0) == '-') {
            return -1;
        }
        return 1;
    }
}
