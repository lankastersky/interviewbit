/*
Scramble String
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. Return 0/1 for this problem.

https://www.interviewbit.com/problems/scramble-string/
*/

  public class Solution {
/*
Lets say the root is the ith character of string s1. 
Then the first part of s1 [0…i) can either match ( be a scrambled string of ) to 
s2[0…i) or s2(i+1 .. L]. Depending on which part s1[0…i) matches to, we match the 
remaining part of s1 to remaining part of s2. Just to clarify when we say s1 matches s2,
we mean s1 is a scrambled string of s2.
*/
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String A, final String B) {
      int n = A.length();
      if (n != B.length() || n == 0) {
          return 0;
      }
      int dp[][][] = new int[n][n][n + 1];
      for (int m[][] : dp) {
        for (int row[] : m) {
          Arrays.fill(row, -1);
        }
      }
      return rec(A, B, 0, 0, n, dp);
    }

    int rec(String A, String B, int s1, int s2, int l, int dp[][][]) {
      int n = A.length();
      if (s1 >= n || s2 >= n) {
        return 0;
      }
      if (A.substring(s1, s1 + l).equals(B.substring(s2, s2 + l))) {
        return 1;
      }
      if (dp[s1][s2][l] != -1) {
        return dp[s1][s2][l];
      }
      int res = 0;
      for (int i = 1; i < l; i++) {
        if (rec(A, B, s1, s2, i, dp) == 1
            && rec(A, B, s1 + i, s2 + i, l - i, dp) == 1) {
          res = 1;
          break;
        }
        if (rec(A, B, s1, s2 + l - i, i, dp) == 1
            && rec(A, B, s1 + i, s2, l - i, dp) == 1) {
          res = 1;
          break;
        }
      }
      dp[s1][s2][l] = res;
      return res;
    }
  }
