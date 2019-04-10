/*
Stepping Numbers

Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.

https://www.interviewbit.com/problems/stepping-numbers/
*/

public class Solution {
    class BTree {
        int val;
        BTree l;
        BTree r;
        BTree(int val) {
            this.val = val;
        }
    }
    
    public ArrayList<Integer> stepnum(int A, int B) {
        if (A > B) {
            return null;
        }
        BTree prev = new BTree(0);
        BTree root = prev;
        for (int i = 1; i <= 9; i++) {
            BTree node = new BTree(i);
            prev.r = node;
            node.l = prev;
            prev = node;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A; i <= B; i++) {
            if (traverse(i, root)) {
                res.add(i);
            }
        }
        return res;
    }
    
    boolean traverse(int i, BTree root) {
        BTree node = findNode(i % 10, root);
        i /= 10;
        
        while (i != 0) {
            int d = i % 10;
            i /= 10;
            if (node.l != null && node.l.val == d) {
                node = node.l;
                continue;
            }
            if (node.r != null && node.r.val == d) {
                node = node.r;
                continue;
            }
            return false;
        }
        return true;
    }
    
    BTree findNode(int d, BTree root) {
        BTree node = root;
        while (node != null && node.val != d) {
            node = node.r;
        }
        return node;
    }
}
