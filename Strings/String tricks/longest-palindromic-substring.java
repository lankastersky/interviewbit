/*
Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"

https://www.interviewbit.com/problems/longest-palindromic-substring/
*/

// Can be solved for O(n), see https://en.wikipedia.org/wiki/Longest_palindromic_substring
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        String res = String.valueOf(s.charAt(0));
        for (int i = 1; i < 2 * (n - 1); i++) {
            int l,r;
            if (i % 2 == 0) {
                l = i / 2 - 1;
                r = i / 2 + 1;
            } else {
                l = i / 2;
                r = i / 2 + 1;
            }
            int length = 0;
            int start = 0;
            while (s.charAt(l) == s.charAt(r)) {
                length = (r - l + 1);
                start = l;
                if (l > 0 && r < n - 1) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            if (length > res.length()) {
                res = s.substring(start, start + length);
            }
        }
        return res;
    }
    
    // class Node {
    //     List<Node> children;
    //     boolean leaf;
    //     Character value;
    //     Node(Character value) {
    //         this.value = value;
    //         children = new ArrayList<>();
    //     }
    //     Node getChild(char c) {
    //         for (Node node: children) {
    //             if (node.value == c) {
    //                 return node;
    //             }
    //         }
    //         return null;
    //     }
    //     Node addChild(char c) {
    //         Node node = new Node(c);
    //         children.add(node);
    //         return node;
    //     }
    // }
    // class Tree {
    //     Node root;
        
    //     void build(String s) {
    //         root = new Node(null);
    //         for (int i = 0; i < s.length(); i++) {
    //             add(s.substring(i, s.length()));
    //         }
    //     }
    //     void add(String s) {
    //         Node cur = root;
    //         for (char c: s.toCharArray()) {
    //             Node temp = cur.getChild(c);
    //             if (temp == null) {
    //                 temp = cur.addChild(c); 
    //             }
    //             cur = temp;
    //         }
    //         cur.leaf = true;
    //     }
    //     boolean exist(String s) {
    //         Node cur = root;
    //         //for (char c: s.toCharArray()) {
    //         for (int i = s.length() - 1; i >= 0; i--) {
    //             char c = s.charAt(i);
    //             cur = cur.getChild(c);
    //             if (cur == null) {
    //                 return false;
    //             }
    //         }
    //         return cur != null;
    //     }
    // }
    // // Doesn't work on A : "abacdfgdcaba"
    // public String longestPalindrome(String s) {
    //     Tree tree = new Tree();
    //     tree.build(s);
    //     int n = s.length();
    //     if (n == 0) {
    //         return "";
    //     }
    //     String res = "";
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j <= n; j++) {
    //             String temp = s.substring(i, j);
    //             if (!tree.exist(temp)) {
    //                 continue;
    //             }
    //             if (temp.length() > res.length()) {
    //                 res = temp;
    //             }
    //         }
    //     }
    //     return res;
    // }
}
