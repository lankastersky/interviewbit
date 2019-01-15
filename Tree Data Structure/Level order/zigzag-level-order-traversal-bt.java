/*
ZigZag Level Order Traversal BT

Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]

https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(A);
        boolean right = true;
        while (!deque.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            Deque<TreeNode> tempDeque = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode cur = right ? deque.pollFirst() : deque.pollLast();
                arr.add(cur.val);
                tempDeque.add(cur);
            }
            res.add(arr);
            while (!tempDeque.isEmpty()) {
                TreeNode cur = right ? tempDeque.pollFirst() : tempDeque.pollLast();
                if (cur.left != null) {
                    deque.add(cur.left);
                }
                if (cur.right != null) {
                    deque.add(cur.right);
                }
            }
            right = !right;
        }
        return res;
    }
}
