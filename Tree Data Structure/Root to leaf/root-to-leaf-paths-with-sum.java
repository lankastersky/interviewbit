/*
Root to Leaf Paths With Sum

Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]

https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        traverse(A, B, res, new ArrayList<Integer>());
        return res;
    }
    
    void traverse(
        TreeNode head, int k, 
        ArrayList<ArrayList<Integer>> res, 
        ArrayList<Integer> cur) {
            
        int sum = k - head.val;
        cur.add(head.val);
        if (head.left == null && head.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(cur));
            }
        } else {
            if (head.left != null) {
                traverse(head.left, sum, res, cur);
            }
            if (head.right != null) {
                traverse(head.right, sum, res, cur);
            }
        }
        cur.remove(cur.size() - 1);
    }
}
