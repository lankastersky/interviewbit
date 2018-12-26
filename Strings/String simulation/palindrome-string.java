/*
Palindrome String

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/palindrome-string/
*/

public class Solution {
    public int isPalindrome(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        String a = A.toLowerCase();
        int n = a.length();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = a.charAt(i);
            if ((c >= '0' && c <= '9') 
                || (c >= 'a' && c <= 'z')) {
                b.append(c);
            }
        }
        a = b.toString();
        //System.out.println("a: " + a);
        n = a.length();
        for (int i = 0; i < n / 2; i++) {
            if (a.charAt(i) != a.charAt(n - i - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
