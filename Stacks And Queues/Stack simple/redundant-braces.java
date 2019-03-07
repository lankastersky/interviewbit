/*
Redundant Braces

Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0

https://www.interviewbit.com/problems/redundant-braces/
*/

public class Solution {
    
    Set<Character> ops = new HashSet<>();

    public Solution() {
        ops.add('+');
        ops.add('-');
        ops.add('*');
        ops.add('/');
    }   
    
    public int braces(String A) {
        int n = A.length();
        if (n == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c != ')') {
                stack.push(c);
                continue;
            }
            boolean opFound = false;
            while (!stack.isEmpty()) {
                c = stack.pop();
                if (ops.contains(c)) {
                    opFound = true;
                } else if (c == '(') {
                    if (!opFound) {
                        return 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
