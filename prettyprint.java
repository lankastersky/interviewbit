/*
PRETTYPRINT
Print concentric rectangular pattern in a 2d matrix. 
Let us show you some examples to clarify what we mean.

Example 1:

Input: A = 4.
Output:

4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Example 2:

Input: A = 3.
Output:

3 3 3 3 3 
3 2 2 2 3 
3 2 1 2 3 
3 2 2 2 3 
3 3 3 3 3 
The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.

You will be given A as an argument to the function you need to implement, and you need to return a 2D array.

https://www.interviewbit.com/problems/prettyprint/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int n = A * 2 - 1;
        int[][] a = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int r = i - 1; r < n - i + 1; r++) {
                a[i - 1][r] = A - i + 1;
                a[n - i][r] = A - i + 1;
                a[r][i - 1] = A - i + 1;
                a[r][n - i] = A - i + 1;
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                res.get(i).add(a[i][j]);
                //System.out.print(a[i][j] + " ");
            }
            //System.out.println();
        }
        return res;
    }
}

