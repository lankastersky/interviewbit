/*
Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.

https://www.interviewbit.com/problems/inorder-traversal/
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.left != null) {
                stack.push(root.left);
                root.left = null;
                continue;
            }
            res.add(root.val);
            stack.pop();
            if (root.right != null) {
                stack.push(root.right);
                root.right = null;
                continue;
            }
        }
        return res;
    }
}
