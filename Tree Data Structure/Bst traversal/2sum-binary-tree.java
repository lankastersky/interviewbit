/*
2-Sum Binary Tree

Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1: 

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2: 

T:        10
         / \
        9   20

K = 40

Return: 0

https://www.interviewbit.com/problems/2sum-binary-tree/
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

    public int t2Sum(TreeNode A, int K) {
        if (A == null) {
            return 0;
        }
        Stack<TreeNode> minStack = new Stack<>();
        Stack<TreeNode> maxStack = new Stack<>();
        TreeNode mn = min(A, minStack);
        TreeNode mx = max(A, maxStack);
        while (mn != mx && mn.val <= mx.val) {
            //System.out.println("mn,mx:" + mn.val + "," + mx.val);
            int cur = mn.val + mx.val;
            if (cur == K) {
                return 1;
            }
            if (cur < K) {
                mn = next(mn, minStack);
            } else {
                mx = prev(mx, maxStack);
            }
        }
        return 0;
    }
    
    TreeNode min(TreeNode node, Stack<TreeNode> path) {
        path.clear();
        while (node != null) {
            path.push(node);
            node = node.left;        
        }
        return path.pop();
    }

    TreeNode max(TreeNode node, Stack<TreeNode> path) {
        path.clear();
        while (node != null) {
            path.push(node);
            node = node.right;        
        }
        return path.pop();
    }
    
    // Too complicated; can be done easier
    TreeNode prev(TreeNode node, Stack<TreeNode> path) {
        path.push(node);
        while (!path.isEmpty()) {
            TreeNode parent = path.pop();
            if (parent.val < node.val) {
                return parent;
            }
            if (parent.left == node || parent.left == null) {
                continue;
            }
            TreeNode down = parent.left;
            while (down != null) {
                path.push(down);
                down = down.right;
            }
            return path.pop();
        }
        return null;
    }

    // Too complicated; can be done easier
    TreeNode next(TreeNode node, Stack<TreeNode> path) {
        path.push(node);
        while (!path.isEmpty()) {
            TreeNode parent = path.pop();
            if (parent.val > node.val) {
                return parent;
            }
            if (parent.right == node || parent.right == null) {
                continue;
            }
            TreeNode down = parent.right;
            while (down != null) {
                path.push(down);
                down = down.left;
            }
            return path.pop();
        }
        return null;
    }
    
    // Map<Integer, Integer> memo = new HashMap<>();
    
    // Uses O(n) memory
    // public int t2Sum(TreeNode A, int B) {
    //     return check(A, B);
    // }
    
    // int check(TreeNode head, int k) {
    //     if (head == null) {
    //         return 0;
    //     }
    //     int find = k - head.val;
    //     if (memo.containsKey(find)) {
    //         return 1;
    //     }
    //     memo.put(head.val, 1);
    //     int res;
    //     res = check(head.left, k);
    //     if (res == 1) {
    //         return res;
    //     }
    //     return check(head.right, k);
    // }
}
