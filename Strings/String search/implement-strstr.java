/*
Implement StrStr

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases.

https://www.interviewbit.com/problems/implement-strstr/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return -1;
        }
        int res = 0;
        int n = A.length();
        int m = B.length();
        int i = 0;
        while (i < n) {
            int j = 0;
            while (i < n && j < m && A.charAt(i) == B.charAt(j)) {
                //System.out.println("i,j,a,b:" + i + "," + j + "," + A.charAt(i) + "," + B.charAt(j));
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            }
            i = i - j + 1;
        }
        return -1;
    }
}
