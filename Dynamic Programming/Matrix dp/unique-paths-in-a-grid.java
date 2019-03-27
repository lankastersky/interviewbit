/*
Unique Paths in a Grid

Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, 
if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100.
 
https://www.interviewbit.com/problems/unique-paths-in-a-grid/
*/

public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        int m = A.get(0).size();
        if (m == 0) {
            return 0;
        }
        
        int[][] memo = new int[n][];
        for (int i = 0; i < n; i++) {
            memo[i] = new int[m];
        }
        if (A.get(0).get(0) == 1) {
            return 0;
        }
        memo[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    continue;                    
                }
                if (i < n - 1 && A.get(i + 1).get(j) != 1) {
                    memo[i + 1][j] += memo[i][j];
                }
                if (j < m - 1 && A.get(i).get(j + 1) != 1) {
                    memo[i][j + 1] += memo[i][j];
                }
            }
        }
        return memo[n - 1][m - 1];
    }
}
