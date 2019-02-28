/*
Reverse the String

Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

https://www.interviewbit.com/problems/reverse-the-string/
*/

public class Solution {
    public String reverseWords(String a) {
        String s[] = a.split("\\s+");
        if (s.length == 0) {
            return "";
        }
        //System.out.println("l:" + s.length);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            //sb.append(reverse(s[i]));
            if (s[i].isEmpty() || s[i].equals(" ")) {
                continue;
            }
            sb.append(s[i]);
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    
    // String reverse(String s) {
    //     Stack<Character> stack = new Stack<>();
    //     for (char c: s.toCharArray()) {
    //         stack.push(c);
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     while (!stack.isEmpty()) {
    //         sb.append(stack.pop());
    //     }
    //     return sb.toString();
    // }
}
