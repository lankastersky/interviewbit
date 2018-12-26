/*
Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

https://www.interviewbit.com/problems/length-of-last-word/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        if (A.length() == 1 && A.charAt(0) != ' ') {
            return 1;
        }
        int n = A.length();
        int right = 0;
        boolean rightTrim = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = A.charAt(i);
            if (c != ' ' && !rightTrim) {
                rightTrim = true;
                right = i;
            } 
            if (c == ' ' && rightTrim) {
                return right - i;
            } else if (i == 0 && rightTrim) {
                return right - i + 1;
            }
        }
        return 0;
    }
}
