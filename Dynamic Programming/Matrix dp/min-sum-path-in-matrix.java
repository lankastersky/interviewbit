/*
Min Sum Path in Matrix

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time. 
Example :

Input : 

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1

https://www.interviewbit.com/problems/min-sum-path-in-matrix/
*/

public class Solution {
    
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int m = A.size();
        int n = A.get(0).size();
        int memo[][] = new int[m][];
        for (int i = 0; i < m; i++) {
            memo[i] = new int[n];
            // for (int j = 0; j < n; j++) {
            //     memo[i][j] = -1;
            // }
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int el = A.get(i).get(j);
                if (i + 1 == m && j + 1 == n) {
                    memo[i][j] = el;
                } else if (i + 1 == m) {
                    memo[i][j] = el + memo[i][j + 1];
                } else if (j + 1 == n) {
                    memo[i][j] = el + memo[i + 1][j];
                } else {
                    int right =el + memo[i + 1][j];
                    int down = el + memo[i][j + 1];
                    memo[i][j] = Math.min(right, down);
                }
            }
        }
        
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(memo[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        return memo[0][0];        
    }
}
