/*
Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.

https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
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
    int MOD = 1003;
    int res = 0;
    public int sumNumbers(TreeNode A) {
        sum(A, new ArrayList<>());
        return res;
    }
    
    void sum(TreeNode root, ArrayList<Integer> cur) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            add(cur);
        }
        sum(root.left, cur);
        sum(root.right, cur);
        cur.remove(cur.size() - 1);
    }
    
    void add(ArrayList<Integer> cur) {
        int mul = 1;
        int sum = 0;
        for (int i = cur.size() - 1; i >= 0; i--) {
            sum = (sum + ((mul % MOD) * cur.get(i)) % MOD) % MOD;
            mul = (mul * 10) % MOD;
        }
        res = (res + sum) % MOD;
    }
}
