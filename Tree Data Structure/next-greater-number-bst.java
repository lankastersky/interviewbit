/*
Next Greater Number BST

Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.

https://www.interviewbit.com/problems/next-greater-number-bst/
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode getSuccessor(TreeNode a, int b) {
        if (a == null) {
            return null;
        }
        
        //TreeNode cur = find(a, b);
        TreeNode cur = null;
        TreeNode root = a;
        while (root != null) {
            if (root.val == b) {
                cur = root;
                break;
            }
            if (b < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (cur == null) {
            return null;
        }
        
        if (cur.right != null) {
            //return findMin(cur.right);
            root = cur.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        } else {
            root = a;
            TreeNode ans = null;
            while (root != cur) {
                if (b < root.val) {
                    ans = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return ans;
        }
    }
    
    // TreeNode find(TreeNode root, int a) {
    //     if (root == null) {
    //         return null;
    //     }
    //     if (root.val == a) {
    //         return root;
    //     } else if (a < root.val) {
    //         return find(root.left, a);
    //     } else {
    //         return find(root.right, a);
    //     }
    // }
    
    // TreeNode findMin(TreeNode root) {
    //     if (root == null) {
    //         return null;
    //     }
    //     if (root.left == null) {
    //         return root;
    //     }
    //     return findMin(root.left);
    // }
}
