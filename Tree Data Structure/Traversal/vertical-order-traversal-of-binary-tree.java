/*
Vertical Order traversal of Binary Tree

Problem Setter: yashpal1995 Problem Tester: RAMBO_tejasv
Given a binary tree, return a 2-D array with vertical order traversal of it.
Go through the example and image for more details.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9
returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]

Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
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
    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        traverse(A);
        for (int level: map.keySet()) {
            ArrayList<Integer> a = map.get(level);
            res.add(a);
        }
        return res;
    }

    class Node {
        int level;
        TreeNode treeNode;
        Node(int l, TreeNode n) {
            level = l;
            treeNode = n;
        }
    }
    
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, root));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node node = queue.remove();
                TreeNode treeNode = node.treeNode;
                int level = node.level;
                ArrayList<Integer> a = map.get(level);
                if (a == null) {
                    a = new ArrayList<>();
                    map.put(level, a);
                }
                a.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(new Node(level - 1, treeNode.left));
                }
                if (treeNode.right != null) {
                    queue.add(new Node(level + 1, treeNode.right));
                }
            }
        }
    }
}
