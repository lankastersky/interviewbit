/*
Matrix Search

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

https://www.interviewbit.com/problems/matrix-search/
*/
public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int N = a.size();
        int M = a.get(0).size();
        int low = 0, high = N * M - 1;
        while (low <= high) {
            int m = (high + low) / 2;
            int val = get(a, m);
            if (val == b) {
                return 1;
            }
            if (val < b) {
                low = m + 1;
            } else {
                high = m - 1;
            }
            println(String.format("i,j: %d,%d", low, high));
        }
        return 0;
    }
    
    int get(ArrayList<ArrayList<Integer>> a, int b) {
        int N = a.size();
        int M = a.get(0).size();
        int i = b / M;
        int j = b % M;
        // b = row * i + j
        return a.get(i).get(j);
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
