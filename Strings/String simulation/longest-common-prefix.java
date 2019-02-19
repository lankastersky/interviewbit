/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.

https://www.interviewbit.com/problems/longest-common-prefix/
*/

public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        int n = A.size();
        if (n == 0) {
            return "";
        }
        String pref = A.get(0);
        for (int i = 1; i < n; i++) {
            int j = 0;
            String cur= A.get(i);
            while (j < Math.min(cur.length(), pref.length()) 
              && cur.charAt(j) == pref.charAt(j)) {
                  j++;
            }
            pref = pref.substring(0, j);
            if (j == 0) {
                break;
            }
        }
        return pref;
    }
}
