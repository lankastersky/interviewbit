/*
Generate all Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/generate-all-parentheses/
*/

public class Solution {
    public int isValid(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int n = A.length();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return 0;
                }
                char popped = stack.pop();
                if (popped != pair(c)) {
                    return 0;
                }
                continue;
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
    
    char pair(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return c;
    }
}
