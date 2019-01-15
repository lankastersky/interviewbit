/*
Balanced Binary Tree
Asked in:  
Amazon
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
         
https://www.interviewbit.com/problems/balanced-binary-tree/
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
    public int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }
        if (A.left == null && (A.right != null && A.right.right != null)) {
            return 0;
        }
        if (A.right == null && (A.left != null && A.left.left != null)) {
            return 0;
        }
        if ((A.left == null) && (A.right != null && A.right.left != null)) {
            return 0;
        }
        if ((A.right == null) && (A.left != null && A.left.right != null)) {
            return 0;
        }
        return isBalanced(A.left) & isBalanced(A.right);
    }
}
