/*
Level Order

Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of 
the tree is much greater than number of nodes on a level.

https://www.interviewbit.com/problems/level-order/
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                level.add(cur);
            }
            ArrayList<Integer> levelValues = new ArrayList<>();
            for (TreeNode cur: level) {
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                levelValues.add(cur.val);
            }
            res.add(levelValues);
        }
        return res;
    }
}
