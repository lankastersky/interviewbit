/*
Ways to Decode

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Example :

Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

https://www.interviewbit.com/problems/ways-to-decode/
*/

public class Solution {
    
    int MAX = 26;
    char ZERO = '0';
    
    public int numDecodings(String A) {
        int n = A.length();
        if (A.charAt(0) == ZERO) {
            return 0;
        }
        int m[] = new int[n + 1];
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {
            int cur = A.charAt(i - 1) - ZERO;
            int num = (A.charAt(i - 2) - ZERO) * 10 + cur;
            if (1 <= cur && cur <= 9) {
                m[i] += m[i - 1];
            }
            if (10 <= num && num <= MAX) {
                m[i] += m[i - 2];
            }
        }
        return m[n];
    }    
    
    // Too complicated.
    // public int numDecodings(String A) {
    //     int m[] = new int[A.length()];
    //     if (A.charAt(0) == ZERO) {
    //         return 0;
    //     }
    //     m[0] = 1;
    //     for (int i = 1; i < A.length(); i++) {
    //         int num = (A.charAt(i - 1) - ZERO) * 10 + (A.charAt(i) - ZERO);
    //         if (num == 0) {
    //             println(i + ":" + num);
    //             return 0;
    //         }
    //         if (10 <= num && num <= MAX) {
    //             if (i > 1) {
    //                 m[i] += m[i - 2]; 
    //             } else {
    //                 m[i] += 1;
    //             }
    //         } else if (num >= MAX && A.charAt(i) == ZERO) {
    //             println(i + ":" + num);
    //             return 0;
    //         }
    //         if (A.charAt(i) != ZERO && A.charAt(i - 1) != ZERO) {
    //             m[i] += m[i - 1];
    //         }
    //         if (m[i] == 0) {
    //             m[i] = m[i - 1];
    //         }
    //     }
    //     return m[A.length() - 1];
    // }
    
    void println(String s) {
        //System.out.println(s);
    }
}
