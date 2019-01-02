/*
Reverse String

Given a string S, reverse the string using stack.

Example :

Input : "abc"
Return "cba"

https://www.interviewbit.com/problems/reverse-string/
*/

public class Solution {
    public String reverseString(String A) {
        if (A == null || A.length() < 2) {
            return A;
        }
        Stack<Character> stack = new Stack<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            stack.push(A.charAt(i));
        }
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = stack.pop();
            x.append(c);
        }
        return x.toString();
    }
}
