/*
Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

Example :
Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.

https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
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
     class FList {
         TreeNode head;
         TreeNode tail;
         FList(TreeNode h, TreeNode t) {
             head = h;
             tail = t;
         }
     }
    
    public TreeNode flatten(TreeNode a) {
        return flat(a).head;
    }
    
    public FList flat(TreeNode a) {
        if (a == null) {
            return new FList(null, null);
        }
        
        FList leftList = flat(a.left);
        FList rightList = flat(a.right);
        if (leftList.head != null) {
            a.right = leftList.head;
        }
        if (leftList.tail != null) {
            leftList.tail.right = rightList.head;
        }
        a.left = null;
        TreeNode tail = rightList.tail;
        if (tail == null) {
            tail = leftList.tail;
        }
        if (tail == null) {
            tail = a.right;
        }
        if (tail == null) {
            tail = a;
        }
        FList res = new FList(a, tail);
        //System.out.println("h,t: " + a.val + "," + tail.val);
        return res;
    }
}
