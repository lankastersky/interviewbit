/*
Simplify Directory Path

Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.

https://www.interviewbit.com/problems/simplify-directory-path/
*/

public class Solution {
    public String simplifyPath(String A) {
        if (A == null || A.isEmpty()) {
            return A;
        }
        //int n = A.length();
        String s = A;
        String word;
        Stack<String> stack = new Stack<>();
        int from = 0;
        //for (int i = 0; i < n; i++) {
        while (true) {
        
            // Gives TLE because it's O(n)
            //int slash = s.indexOf('/');
            
            int slash = -1;
            StringBuilder wordBuilder = new StringBuilder();
            for (int j = from; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '/') {
                    slash = j;
                    break;
                }
                wordBuilder.append(c);
            }

            word = wordBuilder.toString();
            if (word.equals(".")) {
                // do nothing
            } else if (word.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!word.isEmpty()) {
                stack.push(word);
            }
            if (slash == s.length() || slash == -1) {
                break;
            }
            // Gives TLE because it's O(n)
            //s = s.substring(slash + 1, s.length());
            from = slash + 1;
        }
        
        Stack<String> revert = new Stack<>();
        while (!stack.isEmpty()) {
            revert.push(stack.pop());
        }
        
        StringBuilder x = new StringBuilder();
        while (!revert.isEmpty()) {
            x.append("/");
            x.append(revert.pop());
        }
        String res = x.toString();
        if (res.isEmpty() || res.charAt(0) != '/') {
            res = "/" + res;
        }
        return res;
    }
}
