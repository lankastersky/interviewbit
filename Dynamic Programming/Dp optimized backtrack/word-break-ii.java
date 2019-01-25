/*
Word Break II

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is

[
  "cat sand dog", 
  "cats and dog"
]
Make sure the strings are sorted in your result.

https://www.interviewbit.com/problems/word-break-ii/
*/

public class Solution {
    Set<String> dic;
    ArrayList<String> memo[];
    
    public ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        if (dict == null || dict.isEmpty()) {
            return new ArrayList<>();
        }
        dic = new HashSet();
        for (String el: dict) {
            dic.add(el);
        }
        memo = new ArrayList[s.length()];
        ArrayList<String> res = wordBreak(s, 0);
        return res;
    }
    
    ArrayList<String> wordBreak(String s, int cur) {
        if (cur >= s.length()) {
            return new ArrayList<>();
        }
        if (memo[cur] != null) {
            return memo[cur];
        }
        ArrayList<String> res = new ArrayList<>();
        StringBuilder substBuilder = new StringBuilder();
        for (int i = cur; i < s.length(); i++) {
            substBuilder.append(s.charAt(i));
            String subst = substBuilder.toString();
            if (dic.contains(subst)) {
                if (i + 1 == s.length()) {
                    // the end of sentence has been reached
                    res.add(subst);
                    break;
                }
                ArrayList<String> list = wordBreak(s, i + 1);
                for (String str: list) {
                    res.add(subst + " " + str);
                }
            }
        }
        
        // for (String el: res) {
        //     System.out.println(String.valueOf(cur) + ": " + el);
        // }
        
        memo[cur] = res;
        return res;
    }
}
