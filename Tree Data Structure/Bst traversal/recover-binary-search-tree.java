/*
Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST

https://www.interviewbit.com/problems/recover-binary-search-tree/
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
    
    class MinMax {
        Integer min;
        Integer max;
    }
    
    // Works for any two swapped nodes (even not following one by one)
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(res, A);
        return res;
    }
    
    MinMax traverse(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return new MinMax();
        }
        MinMax left = traverse(res, root.left);
        MinMax right = traverse(res, root.right);
        if (left.max != null && right.min != null && left.max > right.min) {
            res.clear();
            res.add(right.min);
            res.add(left.max);
        } else if (left.max != null && left.max > root.val) {
            res.clear();
            res.add(root.val);
            res.add(left.max);
        } else if (right.min != null && root.val > right.min) {
            res.clear();
            res.add(right.min);
            res.add(root.val);
        }
        MinMax minMax = new MinMax();
        minMax.min = root.val;
        minMax.max = root.val;
        if (left.min != null) {
            minMax.min = Math.min(minMax.min, left.min);
        }
        if (right.min != null) {
            minMax.min = Math.min(minMax.min, right.min);
        }
        if (left.max != null) {
            minMax.max = Math.max(minMax.max, left.max);
        }
        if (right.max != null) {
            minMax.max = Math.max(minMax.max, right.max);
        }
        return minMax;
    }
}
