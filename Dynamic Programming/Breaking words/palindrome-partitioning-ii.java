/*
Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example : 
Given 
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

https://www.interviewbit.com/problems/palindrome-partitioning-ii/
*/

public class Solution {
    long memo[];
    
    public int minCut(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        memo = new long[A.length()];
        for (int i = 0; i < A.length(); i++) {
            memo[i] = -1;
        }
        return (int) minCut(A, 0) - 1;
    }
    
    long minCut(String A, int cur) {
        if (cur >= A.length()) {
            return 0;
        }
        if (memo[cur] != -1) {
            return memo[cur];
        }
        StringBuilder sb = new StringBuilder();
        long res = Integer.MAX_VALUE;
        for (int i = cur; i < A.length(); i++) {
            sb.append(A.charAt(i));
            if (pal(sb.toString())) {
                res = Math.min(res, 1 + minCut(A, i + 1));
                //System.out.println(cur + ": " + res + " - " + sb.toString());
            }
        }
        memo[cur] = res;
        return res;
    }
    
    boolean pal(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
