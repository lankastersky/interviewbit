/*
Kth Smallest Element In Tree

Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST 
 
 https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 */
 
 /**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    class Index {
        int val;
    }
    public int kthsmallest(TreeNode A, int B) {
        if (A == null) {
            return -1;
        }
        return kthsmallest(A, B, new Index());
    }
    
    int kthsmallest(TreeNode A, int B, Index cur) {
        if (A == null) {
            return -1;
        }
        if (cur.val == B) {
            return A.val;
        }
        int val = kthsmallest(A.left, B, cur);
        if (val != -1) {
            return val;
        }
        cur.val++;
        if (cur.val == B) {
            return A.val;
        }
        return kthsmallest(A.right, B, cur);
    }
}
