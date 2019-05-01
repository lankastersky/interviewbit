/*
BST Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number 
in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 
It is recommended during an interview to clear all your doubts with the interviewer. Therefore we do not provide all the test
cases

https://www.interviewbit.com/problems/bst-iterator/
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    TreeNode root;
    TreeNode cur;
    Stack<TreeNode> stack = new Stack<>();
    
    public Solution(TreeNode root) {
        this.root = root;
        this.cur = getMin(root);
    }
    
    TreeNode getMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode c = root;
        while (c.left != null) {
            stack.push(c);
            c = c.left;
        }
        return c;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null);
    }

    /** @return the next smallest number */
    public int next() {
        int val = cur.val;
        if (cur.right == null) {
            if (stack.isEmpty()) {
                cur = null;
            } else {
                cur = stack.pop();
            }
        } else {
            TreeNode temp = cur;
            cur = cur.right;
            temp.right = null;
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
