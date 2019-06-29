/*
Multiply Strings

Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

https://www.interviewbit.com/problems/multiply-strings/
*/

public class Solution {
    public String multiply(String A, String B) {
        A = trim0(A);
        B = trim0(B);
        int N = B.length();
        String x = "";
        StringBuilder zeros = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            int d = B.charAt(i) - '0';
            String t = mul(A, d);
            t = trim0(t);
            println(String.format("%s*%d=%s", A, d, t));
            String tt = x;
            x = add(x, t + zeros.toString());
            println(String.format("%s+%s=%s", tt, t + zeros.toString(), x));
            zeros.append('0');
        }
        return x;
    }
    
    String trim0(String A) {
        String x;
        int N = A.length();
        int i = 0;
        while (i < N && A.charAt(i) == '0') {
            i++;
        }
        if (i == N) {
            return "0";
        }
        return A.substring(i, N);
    }
    
    String mul(String A, int d) {
        StringBuilder x = new StringBuilder();
        int N = A.length();
        int m = 0;
        for (int i = N - 1; i >= 0; i--) {
            int a = A.charAt(i) - '0';
            x.insert(0, (a * d + m) % 10);
            m = (a * d + m) / 10;
        }
        if (m != 0) {
            x.insert(0, m);
        }
        return x.toString();
    }
    
    String add(String A, String B) {
        if (A.isEmpty()) {
            return B;
        }
        if (B.isEmpty()) {
            return A;
        }
        if (A.length() < B.length()) {
            String t = A;
            A = B;
            B = t;
        }
        StringBuilder x = new StringBuilder();
        
        int N = A.length();
        int M = B.length();
        int m = 0;
        int L = Math.min(N, M);
        int i = N - 1;
        int j = M - 1;
        int k = 0;
        while (k++ < L) {
            int a = A.charAt(i) - '0';
            int b = B.charAt(j) - '0';
            x.insert(0, (a + b + m) % 10);
            m = (a + b + m) / 10;
            i--;
            j--;
            println(String.format("add:x=%s", x.toString()));
        }
        for (i = N - L - 1; i >= 0; i--) {
            int a = A.charAt(i) - '0';
            x.insert(0, (a + m) % 10);
            m = (a + m) / 10;
            println(String.format("add2:x=%s", x.toString()));
        }
        
        if (m != 0) {
            x.insert(0, m);
            println(String.format("add3:x=%s", x.toString()));
        }
        
        return x.toString();
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
