/*
Symmetric Binary Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/symmetric-binary-tree/
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
    public int isSymmetric(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(A, res);
        int n = res.size();
        for (int i = 0; i < n / 2; i++) {
            if (res.get(i).intValue() != res.get(n - i - 1).intValue()) {
                return 0;
            }
        }
        return 1;
    }
    
    void traverse(TreeNode head, ArrayList<Integer> res) {
        if (head == null) {
            return;
        }
        traverse(head.left, res);
        res.add(head.val);
        traverse(head.right, res);
    }
}
