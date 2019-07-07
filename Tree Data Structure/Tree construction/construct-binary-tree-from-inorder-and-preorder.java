/*
Construct Binary Tree From Inorder And Preorder

Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3

https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/
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
    Map<Integer, Integer> inValToInd = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> B, ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            inValToInd.put(A.get(i), i);
        }
        return build(A, B, 0, A.size() - 1, 0, B.size() - 1);
    }
    
    TreeNode build(
        ArrayList<Integer> in, ArrayList<Integer> pre, int inL, int inR, int preL, int preR) {
        if (inL > inR || preL > preR) {
            return null;
        }
        println(String.format("[%d-%d][%d-%d]", inL, inR, preL, preR));
        int root = pre.get(preL);
        int i = inValToInd.get(root);
        int leftNodes = i - inL;
        int rightNodes = inR - i;
        TreeNode node = new TreeNode(root);
        node.left = build(in, pre, inL, i - 1, preL + 1, preL + leftNodes);
        node.right = build(in, pre, i + 1, inR, preL + leftNodes + 1, preR);
        //node.right = build(in, pre, i + 1, inR, preR - rightNodes + 1, preR);
        return node;
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
