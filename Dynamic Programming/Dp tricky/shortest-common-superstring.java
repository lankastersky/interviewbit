/*
Shortest common superstring

Problem Setter: raghav_aggiwal Problem Tester: dhruvi
Given a set of strings. Find the length of smallest string which
has all the strings in the set as substring

Constraints:
1) 1 <= Number of strings <= 18
2) Length of any string in the set will not exceed 100.

Example:
Input: [“abcd”, “cdef”, “fgh”, “de”]
Output: 8 (Shortest string: “abcdefgh”)

https://www.interviewbit.com/problems/shortest-common-superstring/
*/

public class Solution {
    
    int dp[][];
    
    public int solve(ArrayList<String> A) {
        A = removeSubstrings(A);
        int n = A.size();
        dp = new int[n + 1][];
        int m = (1 << n) - 1;
        for (int i = 0; i <= n; i++) {
            dp[i] = new int[m];
        }
        return traverse(A, 0, -1);    
    }
    
    int traverse(ArrayList<String> A, int mask, int last) {
        int n = A.size();
        int m = (1 << n) - 1;
        if (mask == m) {
            // all words visited
            return 0;
        }
        if (dp[last + 1][mask] != 0) {
            return dp[last + 1][mask];
        }
        int res = Integer.MAX_VALUE;
        // dp[i][mask] = min(dp[x][mask ^ (1«i)] where {mask | (1«x) = 1} )
        for (int i = 0; i < n; i++) {
            if ((mask >> i & 1) == 0) { // i-th word not visited yet
                int mask2 = mask | (1 << i);
                res = Math.min(res, traverse(A, mask2, i) + overlap(A, last, i));
            }
        }
        dp[last + 1][mask] = res;
        return res;
    }
    
    // Returns |b| - |overlapped a suffix and b prefix|
    int overlap(ArrayList<String> A, int a, int b) {
        if (a == -1) {
            return A.get(b).length();
        }
        String s1 = A.get(a);
        String s2 = A.get(b);
        int suffixSize = 0;
        boolean overlapFlag;
        for (int i = 0; i < s1.length(); i++) {
            overlapFlag = true;
            suffixSize = 0;
            for (int j = 0; j < s2.length() && (i + j) < s1.length(); j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    overlapFlag = false;
                    break;
                }
                suffixSize++;
            }
            if (overlapFlag) {
                int res = s2.length() - suffixSize;
                println(a + "," + b + ":" + res);
                return res;
            }
        }
        return s2.length();
    }
    
    ArrayList<String> removeSubstrings(ArrayList<String> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            String s1 = A.get(i);
            if (s1.isEmpty()) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                String s2 = A.get(j);
                if (s2.isEmpty()) {
                    continue;
                }
                if (s1.length() > s2.length()) {
                    if (s1.indexOf(s2) != -1) {
                        A.set(j, "");
                    }
                } else {
                    if (s2.indexOf(s1) != -1) {
                        A.set(i, "");
                    }
                }
            }            
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!A.get(i).isEmpty()) {
                res.add(A.get(i));
            }
        }
        return res;
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
