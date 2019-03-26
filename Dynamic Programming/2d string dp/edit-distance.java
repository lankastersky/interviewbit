/*
Edit Distance

Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.

https://www.interviewbit.com/problems/edit-distance/
*/

public class Solution {
    int[][] memo;
    public int minDistance(String A, String B) {
        if (A.length() == 0) {
            return B.length();
        }
        if (B.length() == 0) {
            return A.length();
        }
        int n = A.length();
        int m = B.length();
        memo = new int[n][];
        for (int i = 0; i < n; i++) {
            memo[i] = new int[m];
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }
        int res = dist(A, B);
        
        for (int i = 0; i < n; i++) {
            memo[i] = new int[m];
            for (int j = 0; j < m; j++) {
                print(String.format("%d,%d:%d", i, j, memo[i][j]));
            }
            println("");
        }
        
        return res;
    }
    
    // Based on https://en.wikipedia.org/wiki/Levenshtein_distance#Computing_Levenshtein_distance
    int dist(String A, String B) {
        if (A.length() == 0) {
            return B.length();
        }
        if (B.length() == 0) {
            return A.length();
        }
        int i = A.length() - 1;
        int j = B.length() - 1;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        if (A.charAt(0) != B.charAt(0)) {
            res = 1;
        }
        memo[i][j] = Math.min(
            dist(A.substring(1), B.substring(1)) + res,
            Math.min(
                dist(A.substring(1), B) + 1,
                dist(A, B.substring(1)) + 1
                )
            );
        return memo[i][j];
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }

    void println(String s) {
        //System.out.println(s);
    }
}
