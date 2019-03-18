/*
Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes’ values.

Example :

Given binary tree

   1
    \
     2
    /
   3
return [3,2,1].

Using recursion is not allowed.

https://www.interviewbit.com/problems/postorder-traversal/
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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(A);
        while (!stack.isEmpty()) {
            TreeNode el = stack.peek();
            if (el.left != null) {
                stack.push(el.left);
                el.left = null;
            } else if (el.right != null) {
                stack.push(el.right);
                el.right = null;
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }
}
