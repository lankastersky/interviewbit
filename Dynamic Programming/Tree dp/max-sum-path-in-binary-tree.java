/*
Max Sum Path in Binary Tree

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.

https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
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
    
    long max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode A) {
        maxPath(A);
        return (int) max;
    }
    
    int maxPath(TreeNode A) {
        if (A == null) {
            return Integer.MIN_VALUE;
        }

        long result = A.val;

        long leftsum = maxPath(A.left);
        long rightsum = maxPath(A.right);
        result = Math.max(rightsum + A.val, 
            Math.max(
                leftsum + A.val, 
                Math.max(A.val, leftsum + A.val + rightsum)
            )
        );
        max = Math.max(max, result);
        
        long longestPath = 
            Math.max(A.val, Math.max(A.val + leftsum, A.val + rightsum));
            
        return (int) longestPath;
    }
}
