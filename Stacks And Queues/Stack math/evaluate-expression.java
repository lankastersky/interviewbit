/*
Evaluate Expression

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

https://www.interviewbit.com/problems/evaluate-expression/
*/

public class Solution {
    public int evalRPN(ArrayList<String> A) {
        if (A == null || A.isEmpty()) {
            return -1;
        }
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        int x = 0;
        int left = 0;
        int right = 0;
        String word;
        
        if (A.size() == 1) {
            word = A.get(0);
            if (!operators.contains(word)) {
                return Integer.valueOf(word);
            }
            return -1;
        }
        
        for (int i = 0; i < A.size(); i++) {
            word = A.get(i);
            if (!operators.contains(word)) {
                stack.push(word);
                continue;
            }
            if (stack.isEmpty()) {
                return -1;
            }
            right = Integer.valueOf(stack.pop());
            if (stack.isEmpty()) {
                if (word.equals("-")) {
                    x = -right;
                } else if (word.equals("+")) {
                    x = right;
                } else {
                    return -1;
                }
            } else {
                left = Integer.valueOf(stack.pop());
                if (word.equals("+")) {
                    x = left + right;
                } else if (word.equals("-")) {
                    x = left - right;
                } else if (word.equals("*")) {
                    x = left * right;
                } else {
                     x = left / right;   
                }
            }
            stack.push(String.valueOf(x));
            //System.out.println("l,r,x: " + left + "," + right + "," + x);
        }
        
        return x;
    }
}
