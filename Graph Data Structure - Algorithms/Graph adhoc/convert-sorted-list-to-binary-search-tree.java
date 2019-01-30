/*
Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees 
 of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
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
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        if (a == null) {
            return null;
        }
        int length = 0;
        ListNode cur = a;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return buildTree(a, length);
    }
    
    TreeNode buildTree(ListNode a, int length) {
        if (a == null || length <= 0) {
            return null;
        }
        ListNode cur = a;
        int i = 0;
        for (; i < length / 2; i++) {
            cur = cur.next;
            if (cur == null) {
                return null;
            }
        }
        TreeNode root = new TreeNode(cur.val);
        // System.out.println(
        //     "cur, root, length: " + a.val + "," + root.val + "," + length);
        root.left = buildTree(a, i);
        root.right = buildTree(cur.next, length - i - 1);
        return root;
        
    }
}
