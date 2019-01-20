/*
Next Pointer Binary Tree

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example :

Given the following perfect binary tree,

         1
       /  \
      2    5
     / \  / \
    3  4  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL
Note that using recursion has memory overhead and does not qualify for constant space.

https://www.interviewbit.com/problems/next-pointer-binary-tree/
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
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        Queue<TreeLinkNode> tempQueue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode right = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.remove();
            right = queue.peek();
            node.next = right;
            if (node.left != null) {
                tempQueue.add(node.left);
            }
            if (node.right != null) {
                tempQueue.add(node.right); 
            }
            if (queue.isEmpty()) {
                queue.addAll(tempQueue);
                tempQueue.clear();
            }
        }
    }
}
