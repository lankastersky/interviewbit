/*
Add Binary Strings

Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.

https://www.interviewbit.com/problems/add-binary-strings/
*/

public class Solution {
    public String addBinary(String A, String B) {
        int n = A.length();
        int m = B.length();
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();
        int add = 0;
        char ZERO = '0';
        while (i >= 0 && j >= 0) {
            int d1 = A.charAt(i) - ZERO;
            int d2 = B.charAt(j) - ZERO;
            int d = (d1 + d2 + add) % 2;
            char c = (char) (d + ZERO);
            if (d1 + d2 + add > 1) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, c);
            i--;
            j--;
        }
        String s = (i >= 0) ? A : B;
        int k = (i >= 0) ? i : j;
        while (k >= 0) {
            int d1 = s.charAt(k) - ZERO;
            int d = (d1 + add) % 2;
            char c = (char) (d + ZERO);
            if (d1 + add > 1) {
                add = 1;
            } else {
                add = 0;
            }
            sb.insert(0, c);
            k--;
        }
        if (add == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
