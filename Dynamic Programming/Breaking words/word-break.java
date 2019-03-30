/*
Word Break

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/word-break/
*/

public class Solution {

    // word - used flag
    Map<String, Boolean> map = new HashMap<>();
    String s;
    int[] memo;

    public int wordBreak(String sin, ArrayList<String> dict) {
        if (sin.length() == 0) {
            return 0;
        }
        int n = dict.size();
        for (String word: dict) {
            map.put(word, false);
        }
        s = sin;
        memo = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();
        stack.push(0);
        iStack.push(0);
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int iStart = iStack.pop();
            if (start >= s.length()) {
                return 1;
            }
            if (memo[start] == 1) {
                continue;
            }
            boolean found = false;
            for(int i = iStart + 1; i <= s.length(); i++) {
                String subs = s.substring(start, i);
                if (map.containsKey(subs)) {
                    println(String.format("%d-%d:%s", start, i, subs));
                    iStack.push(i);
                    iStack.push(i);
                    stack.push(start);
                    stack.push(i);
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            memo[start] = 1;
        }
        return 0;
    }
    
    // Gives Stack overflow.
    // word - used flag
    // Map<String, Boolean> map = new HashMap<>();
    // String s;
    // int[] memo;
    
    // public int wordBreak(String sin, ArrayList<String> dict) {
    //     if (sin.length() == 0) {
    //         return 0;
    //     }
    //     int n = dict.size();
    //     for (String word: dict) {
    //         map.put(word, false);
    //     }
    //     s = sin;
    //     memo = new int[s.length()];
    //     return rec(0);
    // }
    
    // int rec(int start) {
    //     if (start >= s.length()) {
    //         return 1;
    //     }
    //     if (memo[start] == 1) {
    //         return 0;
    //     }
    //     for(int i = start + 1; i <= s.length(); i++) {
    //         String subs = s.substring(start, i);
    //         if (map.containsKey(subs)) {
    //             println(String.format("%d-%d:%s", start, i, subs));
    //             if (rec(i) == 1) {
    //                 return 1;
    //             }
    //         }
    //     }
    //     memo[start] = 1;
    //     return 0;
    // }
    
    void print(String s) {
        //System.out.print(s + " ");
    }
    void println(String s) {
        //System.out.println(s);
    }
}
