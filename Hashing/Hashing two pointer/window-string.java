/*
Window String

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time 
complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

https://www.interviewbit.com/problems/window-string/
*/

public class Solution {
    public String minWindow(String S, String T) {
        int s = S.length();
        int t = T.length();
        if (s * t == 0) {
            return "";
        }
        if (s < t) {
            return "";
        }
        
        // Stores chars (and their count) which are left to be found
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t; i++) {
            char c = T.charAt(i);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }

        int i = 0;
        int j = 0;
        Integer start = null;
        Integer end = null;
        int total = 0;
        for (; j < s; j++) {
            char c = S.charAt(j);
            if (!tMap.containsKey(c)) {
                continue;
            }
            int ccount = tMap.get(c);
            ccount--;
            tMap.put(c, ccount);
            if (ccount >= 0) {
                total++;
            }
            
            if (total < t) {
                continue;
            }
            
            c = S.charAt(i);
            while (!tMap.containsKey(c) || tMap.get(c) < 0) {
                if (tMap.containsKey(c)) {
                    ccount = tMap.get(c);
                    ccount++;
                    tMap.put(c, ccount);
                }
                i++;
                c = S.charAt(i);
            }
            
            if (start == null || j - i < end - start) {
                start = i;
                end = j;
            }
        }
        if (start == null) {
            return "";
        }
        return S.substring(start, end + 1);
    }
}
