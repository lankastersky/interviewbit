/*
Binary Tree From Inorder And Postorder

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return : 
            1
           / \
          2   3
          
https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/
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
    //Map<Integer, Integer> postToPos = new HashMap<>();
    Map<Integer, Integer> inToPos = new HashMap<>();
    ArrayList<Integer> in;
    ArrayList<Integer> post;

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        in = A;
        post = B;
        int n = in.size();
        for (int i = 0; i < n; i++) {
            inToPos.put(in.get(i), i);
        }
        return traverse(0, n - 1, 0, n - 1);
    }
    
    TreeNode traverse(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        if (postLeft > postRight) {
            return null;
        }

        // Last postorder is root
        int val = post.get(postRight);
        TreeNode node = new TreeNode(val);
        
        // find the position of this node in inorder
        int i = inToPos.get(val);
        
        // find number of nodes in left and right subtree
        int leftNodes = i - inLeft - 1;
        int rightNodes = inRight - i;
        
        node.left = traverse(inLeft, i - 1, postLeft, postLeft + leftNodes);
        node.right = traverse(i + 1, inRight, postLeft + leftNodes + 1, postRight - 1);
        return node;
    }
    
    // Too complicated
    // public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
    //     in = A;
    //     post = B;
    //     int n = in.size();
    //     for (int i = 0; i < n; i++) {
    //         postToPos.put(post.get(i), i);
    //     }
    //     return traverse(0, n - 1);
    // }
    
    // TreeNode traverse(int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }
    //     // find elem from inorder with max index in postorder. It will be root
    //     int maxPostPos = -1;
    //     int inPos = -1;
    //     for (int i = left; i <= right; i++) {
    //         int el = in.get(i);
    //         int postPos = postToPos.get(el);
    //         if (maxPostPos < postPos) {
    //             maxPostPos = postPos;
    //             inPos = i;
    //         }
    //     }
    //     int el = post.get(maxPostPos);
    //     TreeNode node = new TreeNode(el);
    //     node.left = traverse(left, inPos - 1);
    //     node.right = traverse(inPos + 1, right);
    //     return node;
    // }
}
