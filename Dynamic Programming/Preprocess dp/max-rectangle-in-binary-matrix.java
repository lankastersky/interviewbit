/*
Max Rectangle in Binary Matrix

Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 

As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)

https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
*/

public class Solution {
    public int maximalRectangle(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int res = 0;
        
        int m[][] = new int[M][];
        for (int i = 0; i < M; i++) {
            m[i] = new int[N];
            for (int j = 0; j < N; j++) {
                m[i][j] = A[i][j];
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (m[i][j] == 1) {
                    m[i][j] += m[i][j + 1];
                }
            }
        }

        // for (int i = 0; i < M; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(String.format("%3d", m[i][j]));
        //     }
        //     System.out.println();
        // }
        // System.out.println("--");
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int width = m[i][j];
                res = Math.max(res, width);
                for (int k = i + 1; k < M; k++) {
                    if (m[k][j] == 0) {
                        break;
                    }
                    width = Math.min(width, m[k][j]);
                    res = Math.max(res, width * (k - i + 1));
                }
            }
        }

        return res;
    }
}
