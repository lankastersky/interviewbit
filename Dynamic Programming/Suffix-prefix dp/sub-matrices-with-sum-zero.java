/*
Sub Matrices with sum Zero

Problem Setter: mihai.gheorghe Problem Tester: sneh_gupta
Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the sub matrix 
is equal to 0. (note: elements might be negative).

Example:

Input

-8 5  7
3  7 -8
5 -8  9
Output
2

Explanation
-8 5 7
3 7 -8
5 -8 9

-8 5 7
3 7 -8
5 -8 9

https://www.interviewbit.com/problems/sub-matrices-with-sum-zero/
*/

public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        if (N == 0) {
            return 0;
        }
        int M = A.get(0).size();
        if (M == 0) {
            return 0;
        }
        // cumulative matrix
        int[][] m = new int[N][];
        for (int i = 0; i < N; i++) {
            m[i] = new int[M];
        }
        // Setting left and upper edges
        m[0][0] = A.get(0).get(0);
        for (int i = 1; i < N; i++) {
            m[i][0] = A.get(i).get(0) + m[i - 1][0];
        }
        for (int j = 1; j < M; j++) {
            m[0][j] = A.get(0).get(j) + m[0][j - 1];
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                m[i][j] = A.get(i).get(j) + m[i = 1][j] + m[i][j - 1] - m[i - 1][j - 1];
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(m[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int res = 0;

        for (int r1 = 0; r1 < N; r1++) {
            for (int r2 = r1; r2 < N; r2++) {
                // sum - number of such sums
                Map<Integer, Integer> map = new HashMap<>();
                // Find all sums A[0..i] and store in the map
                for (int c = 0; c < M; c++) {
                    int colsum;
                    if (r1 > 0 ) {
                        colsum = m[r2][c] - m[r1 - 1][c];
                    } else {
                        colsum = m[r2][c];
                    }
                    if (map.containsKey(colsum)) {
                        map.put(colsum, map.get(colsum) + 1);
                    } else {
                        map.put(colsum, 1);
                    }
                }
                // We count all pairs of equal sums below.
                // To count the case when sum = 0, adding a fake 0 (sum of empty array). 
                if (map.containsKey(0)) {
                    map.put(0, map.get(0) + 1);
                }
                for (int sum: map.keySet()) {
                    int val = map.get(sum);
                    // if sum(A[0..i]) = sum(A[0..j]),
                    // than the subarray A[j + 1..i] will have zero sum.
                    if (val > 1) {
                        // Number of pairs
                        int comb = val * (val - 1) / 2; 
                        res += comb;
                    }
                }
            }
        }

        // Gives TLE, O(n^4)
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         for (int k = i; k < N; k++) {
        //             for (int l = j; l < M; l++) {
        //                 // Check submatrix (i, j) x (k, l)
        //                 int sum = -666;
        //                 if (i > 0 && j > 0) {
        //                     sum = m[k][l] - m[i - 1][l] - m[k][j - 1] + m[i - 1][j - 1];
        //                 } else if (i > 0) {
        //                     sum = m[k][l] - m[i - 1][l];
        //                 } else if (j > 0) {
        //                     sum = m[k][l] - m[k][j - 1];
        //                 } else {
        //                     sum = m[k][l];
        //                 }
        //                 //System.out.println(String.format("%d,%dx%d,%d:%d", i, j, k, l, sum));
        //                 if (sum == 0) {
        //                     res++;
        //                 }
        //             }
        //         }
        //     }
        // }
        return res;
    }
}
