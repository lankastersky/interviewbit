/*
Unique Binary Search Trees II

Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

https://www.interviewbit.com/problems/unique-binary-search-trees-ii/
*/

public class Solution {
    int memo[];
    
    public int numTrees(int A) {
        memo = new int[A];
        for (int i = 0; i < A; i++) {
            memo[i] = -1;
        }
        return num(A);
    }
    
    int num(int A) {
        if (A == 0) {
            return 1;
        }
        if (memo[A - 1] != -1) {
            return memo[A - 1];
        }
        int result = 0;
        for (int i = 0; i < A; i++) {
            result += num(i) * num(A - i - 1);
        }
        memo[A - 1] = result;
        return result;
    }
}
