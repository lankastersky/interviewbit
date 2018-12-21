/*
Grid Unique Paths

A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
              
https://www.interviewbit.com/problems/grid-unique-paths/
*/

public class Solution {
    public int uniquePaths(int A, int B) {
        if (A <=0 || B <= 0) {
            return 0;
        }
        int[][] a = new int[A][B];
        a[0][0] = 1;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (i < A - 1) {
                    a[i + 1][j] += a[i][j];
                }
                if (j < B - 1) {
                    a[i][j + 1] += a[i][j];
                }
                
            }
        }
        
        // for (int i = 0; i < A; i++) {
        //     for (int j = 0; j < B; j++) {
        //         System.out.print(a[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return a[A - 1][B - 1];
    }
}
