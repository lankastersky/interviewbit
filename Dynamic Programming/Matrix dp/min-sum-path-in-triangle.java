/*
Min Sum Path in Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 

https://www.interviewbit.com/problems/min-sum-path-in-triangle/
*/

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        if (n == 0) {
            return 0;
        }
        int m = a.get(n - 1).size();
        if (m == 0) {
            return 0;
        }
        int[][] memo = new int[n][];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = a.get(i);
            memo[i] = new int[row.size()];
        }
        
        memo[0][0] = a.get(0).get(0);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = a.get(i);
            for (int j = 0; j < row.size(); j++) {
                Integer l = leftAdj(memo, i, j);
                Integer r = rightAdj(memo, i, j);
                memo[i][j] = Math.min(l, r) + a.get(i).get(j);
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < memo[i].length; j++) {
        //         System.out.print(memo[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> row = a.get(n - 1);
        for (int j = 0; j < row.size(); j++) {
            res = Math.min(res, memo[n - 1][j]);
        }
        return res;
    }
    
    Integer leftAdj(int[][] memo, int i, int j) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        if (j - 1 < 0) {
            return Integer.MAX_VALUE;
        }
        return memo[i - 1][j - 1];
    }

    Integer rightAdj(int[][] memo, int i, int j) {
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        if (j >= memo[i - 1].length) {
            return Integer.MAX_VALUE;
        }
        return memo[i - 1][j];
    }    
}
