/*
Sorted Array To Balanced BST

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : [1, 2, 3]
A height balanced BST  : 

      2
    /   \
   1     3

https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
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
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        if (a == null) {
            return null;
        }
        return sortedArrayToBST(a, 0, a.size() - 1);
    }
    
    TreeNode sortedArrayToBST(List<Integer> a, int left, int right) {
        if (left < 0 || right >= a.size()) {
            return null;
        }
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(a.get(left));
        }
        int mid = (left + right) / 2;
        TreeNode cur = new TreeNode(a.get(mid));
        cur.left = sortedArrayToBST(a, left, mid - 1);
        cur.right = sortedArrayToBST(a, mid + 1, right);
        return cur;
    }
}
