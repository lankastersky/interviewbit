/*
Longest valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses
substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

https://www.interviewbit.com/problems/longest-valid-parentheses/
*/

public class Solution {
    
    public int longestValidParentheses(String A) {
        int n = A.length();
        int res = 0;
        int left = 0;
        int right = 0;
        for (char c: A.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                res = Math.max(res, left * 2);
            }
            if (left < right) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = n - 1; i >=0; i--) {
            char c = A.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                res = Math.max(res, left * 2);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return res;
    }
    
    void println(String s) {
        System.out.println(s);
    }
}
