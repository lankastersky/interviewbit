/*
Least Common Ancestor

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.


https://www.interviewbit.com/problems/least-common-ancestor/
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
    public int lca(TreeNode A, int first, int second) {
                      
        LinkedList<Integer> firstArray = new LinkedList<>();
        LinkedList<Integer> secondArray = new LinkedList<>();
        boolean findFirst = find(first, A, firstArray);
        boolean findSecond = find(second, A, secondArray);
        
        // for (int el: firstArray) {
        //     System.out.print(el + ", ");
        // }
        // System.out.println();
        // for (int el: secondArray) {
        //     System.out.print(el + ", ");
        // }
        // System.out.println();
        
        if (findFirst && findSecond) {
            int n = Math.min(firstArray.size(), secondArray.size());
            int i = 0;
            Iterator<Integer> iter1 = firstArray.iterator();
            Iterator<Integer> iter2 = secondArray.iterator();
            while (i < n) {
                int left = iter1.next();
                int right = iter2.next();
                if (left != right) {
                    break;
                }
                i++;
            }
            if (i > 0) {
                return firstArray.get(i - 1);
            }
        }
        return -1;
    }
    
    boolean find(int a, TreeNode root, LinkedList<Integer> ancestors) {
        if (root == null) {
            return false;
        }
        ancestors.add(root.val);
        if (root.val == a) {
            return true;
        }
        boolean result = false;
        result = find(a, root.left, ancestors);
        if (result) {
            return true;
        }
        result = find(a, root.right, ancestors);
        if (result) {
            return true;
        }
        ancestors.removeLast();
        return result;
    }
}
