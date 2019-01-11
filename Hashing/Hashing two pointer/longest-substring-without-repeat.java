/*
Longest Substring Without Repeat

Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

https://www.interviewbit.com/problems/longest-substring-without-repeat/
*/

   public class Solution {
        public int lengthOfLongestSubstring(String A) {
            if (A == null || A.isEmpty()) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int x = 0;
            int l = 0;
            for (int i = 0; i < A.length(); i++) {
                Character c = A.charAt(i);
                if (map.get(c) == null) {
                    map.put(c, i);
                    continue;
                }
                if (x == 0) {
                    x = i;
                    //System.out.println("x,i: " + x + "," + i);
                }
                x = Math.max(x, i - l);
                //System.out.println("x,l,i: " + x + "," + l + "," + i);
                int prev = map.get(c);
                while (l <= prev) {
                    char cl = A.charAt(l);
                    map.put(cl, null);
                    l++;
                }
                map.put(c, i);
            }
            x = Math.max(x, A.length() - l);
            //System.out.println("x,l: " + x + ", " + l);
            return x;
        }
    }
