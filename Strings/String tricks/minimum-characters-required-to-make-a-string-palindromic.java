/*
Minimum Characters required to make a String Palindromic

You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

Example:
Input: ABC
Output: 2
Input: AACECAAAA
Output: 2

https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
*/

public class Solution {
    public int solve(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        if (A.length() == 1) {
            return 0;
        }
        int l = A.length();
        int max = 0;
        for (int n = 1; n <= l; n++) {
            boolean lp = true;
            int i;
            for (i = 0; i < n / 2; i++) {
                char lc = A.charAt(i);
                char rc = A.charAt(n - i - 1);
                //System.out.println("n,i,l,r:" + n + "," + i + "," + lc + "," + rc);
                if (lc != rc) {
                    lp = false;
                    break;
                }
            }
            if (lp) {
                max = Math.max(max, n);
            }
        }
        return l - max;
    }
}
