/*
Kingdom War

Two kingdoms are on a war right now, kingdom X and kingdom Y. As a war specialist of kingdom X, you scouted kingdom Y area.

A kingdom area is defined as a N x M grid with each cell denoting a village.
Each cell has a value which denotes the strength of each corresponding village.
The strength can also be negative, representing those warriors of your kingdom who were held hostages.

There’s also another thing to be noticed.

The strength of any village on row larger than one (2<=r<=N) is stronger or equal to the strength of village which is exactly
above it.
The strength of any village on column larger than one (2<=c<=M) is stronger or equal to the strength of vilage which is exactly 
to its left.
(stronger means having higher value as defined above).
So your task is, find the largest sum of strength that you can erase by bombing one sub-matrix in the grid.

Input format:

First line consists of 2 integers N and M denoting the number of rows and columns in the grid respectively.
The next N lines, consists of M integers each denoting the strength of each cell.

1 <= N <= 1500
1 <= M <= 1500
-200 <= Cell Strength <= 200
Output:

The largest sum of strength that you can get by choosing one sub-matrix.
Example:

Input:
3 3
-5 -4 -1
-3 2 4
2 5 8

Output:
19

Explanation:
Bomb the sub-matrix from (2,2) to (3,3): 2 + 4 + 5 + 8 = 19

https://www.interviewbit.com/problems/kingdom-war/
*/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        int m = A.get(0).size();
        int memo[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            memo[i] = new int[m];
            for (int j = 0; j < m; j++) {
                memo[i][j] = A.get(i).get(j);
                if (i > 0) {
                    memo[i][j] += memo[i - 1][j]; 
                }
                if (j > 0) {
                    memo[i][j] += memo[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    memo[i][j] -= memo[i - 1][j - 1];
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                print(memo[i][j] + " ");
            }
            println("");
        }
        
        int res = A.get(n - 1).get(m - 1);
        for (int i = n - 2; i >= -1; i--) {
            for (int j = m - 2; j >= -1; j--) {
                int tmp = memo[n - 1][m - 1];
                if (i == -1 && j == -1) {
                    res = Math.max(res, memo[n - 1][m - 1]);
                } else if (i == -1) {
                    res = Math.max(res, tmp - memo[n - 1][j]);
                } else if (j == -1) {
                    res = Math.max(res, tmp - memo[i][m - 1]);
                } else {
                    res = Math.max(res, 
                        tmp + memo[i][j] - memo[i][m - 1] - memo[n - 1][j]);
                }
                println(i + "," + j + ": " + res);
            }
        }
        return res;
    }
    
    void print(String i) {
        //System.out.print(i + " ");
    }
    
    void println(String i) {
        //System.out.println(i);
    }
}
