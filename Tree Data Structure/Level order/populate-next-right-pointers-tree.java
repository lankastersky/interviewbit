/*
Populate Next Right Pointers Tree

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set 
to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
 Note 1: that using recursion has memory overhead and does not qualify for constant space.
 Note 2: The tree need not be a perfect binary tree.
 
https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        while (cur != null) {
            TreeLinkNode level = null;
            TreeLinkNode prev = null;  
            while (cur != null) {
                if (cur.left != null) {
                    if (level == null) {
                        level = cur.left;
                    }
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (level == null) {
                        level = cur.right;
                    }
                    if (prev != null) {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = level;
        }
        
        // Uses extra space
        // LinkedList<TreeLinkNode> queue = new LinkedList<>();
        // LinkedList<TreeLinkNode> queue2 = new LinkedList<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     TreeLinkNode next = null;
        //     while (!queue.isEmpty()) {
        //         TreeLinkNode node = queue.removeFirst();
        //         if (node.right != null) {
        //             queue2.addLast(node.right);
        //         }
        //         if (node.left != null) {
        //             queue2.addLast(node.left);
        //         }
        //         node.next = next;
        //         next = node;
        //     }
        //     queue = queue2;
        //     queue2 = new LinkedList<>();
        // }
    }
}
