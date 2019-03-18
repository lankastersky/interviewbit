/*
Inorder Traversal of Cartesian Tree

Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1

https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
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
    public TreeNode buildTree(ArrayList<Integer> A) {
        return build(A, 0, A.size() - 1);
    }
    
    TreeNode build(ArrayList<Integer> A, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = max(A, l, r);
        TreeNode node = new TreeNode(A.get(m));
        node.left = build(A, l, m - 1);
        node.right = build(A, m + 1, r);
        return node;
    }
    
    int max(ArrayList<Integer> A, int l, int r) {
        int max = l;
        for (int i = l; i <= r; i++) {
            if (A.get(i) > A.get(max)) {
                max = i;
            }
        }
        return max;
    }
}
