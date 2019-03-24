/*
Largest area of rectangle with permutations

Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid
such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix
i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more clarity.

Lets say we are given a binary grid of 3 * 3 size.

1 0 1
0 1 0
1 0 0

At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e either 
of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we can take
column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:

1 1 0
0 0 1
1 0 0

Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given grid.
Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case. 
Hence 2 will be the answer in this case.

https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/
*/

public class Solution {

    int[] cols;
    int res;
    // row - col -> cum sum
    int cum[][];
    int n;
    int m;
    
    public int solve(ArrayList<ArrayList<Integer>> A) {
        n = A.size();
        if (n == 0) {
            return 0;
        }
        m = A.get(0).size();
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                print(A.get(i).get(j) + " ");
            }
            println("");
        }
        println("");

        cum = new int[n][];
        for (int i = 0; i < n; i++) {
            cum[i] = new int[m];
        }
        
        for (int j = 0; j < m; j++) {
            cum[0][j] = A.get(0).get(j);
            for (int i = 1; i < n; i++) {
                if (A.get(i).get(j) == 1) {
                    cum[i][j] = cum[i - 1][j] + A.get(i).get(j);
                } else {
                    cum[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                print(cum[i][j] + " ");
            }
            println("");
        }
        println("");

        res = 0;
        for (int i = 0; i < n; i++) {
            // sort indices by desc
            final ArrayList<Integer> row = new ArrayList<>();
            Integer[] ind = new Integer[m];
            for (int j = 0; j < m; j++) {
                row.add(cum[i][j]);
                ind[j] = j;
            }
            Arrays.sort(ind, (j1, j2) -> row.get(j2) - row.get(j1));
            for (int j = 0; j < m; j++) {
                print(ind[j] + " ");
            }
            println("");

            // calc rectangle of 1's            
            int c = 0;
            int j = ind[c];
            int height = cum[i][j];
            res = Math.max(res, height);
            println("initial height[" + i + "]=" + height);
            for (int k = c + 1; k < m; k++) {
                int jcur = ind[k];
                if (cum[i][jcur] == 0) {
                    break;
                }
                height = Math.min(height, cum[i][jcur]);
                res = Math.max(res, height * (k - c + 1));
            }
        }

        // perm(A, new ArrayList<>());

        return res;
    }

    // Gives TLE
    // void perm(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> p) {
    //     if (p.size() == m) {
    //         check(A, p);
    //         return;
    //     }
    //     for (int i = 0; i < m; i++) {
    //         if (cols[i] == -1) {
    //             continue;
    //         }
    //         cols[i] = -1;
    //         p.add(i);
    //         perm(A, p);
    //         cols[i] = 0;
    //         p.remove(p.size() - 1);
    //     }
    // }

    // void check(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> p) {
    //     for (int el: p) {
    //         print(el + " ");
    //     }
    //     println("");
        
    //     for (int i = 0; i < n; i++) {
    //         for (int c = 0; c < m; c++) {
    //             int j = p.get(c);
    //             int height = cum[j][i];
    //             for (int k = c + 1; k < m; k++) {
    //                 int jcur = p.get(k);
    //                 if (cum[jcur][i] == 0) {
    //                     break;
    //                 }
    //                 height = Math.min(height, cum[jcur][i]);
    //                 res = Math.max(res, height * (k - c + 1));
    //             }
    //         }
    //     }
    //     println("res: " + res);
    // }
    
    void print(String  s) {
        //System.out.print(s);
    }
    void println(String s) {
        //System.out.println(s);
    } 
}
