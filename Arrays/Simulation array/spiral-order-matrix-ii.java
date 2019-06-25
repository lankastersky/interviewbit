/*
Spiral Order Matrix II

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]

https://www.interviewbit.com/problems/spiral-order-matrix-ii/
*/

public class Solution {
    final int RIGHT = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int UP = 3;
    
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (A == 0) {
            return res;
        }
        int m[][] = new int[A][];
        for (int i = 0; i < A; i++) {
            m[i] = new int[A];
        }
        int d = RIGHT;
        int i = 0;
        int j = 0;
        int I1 = 0;
        int I2 = A - 1;
        int J1 = 0;
        int J2 = A - 1;
        int cur = 1;
        while (cur <= A * A) {
            println(i + " " + j);
            m[i][j] = cur;
            cur++;
            switch (d) {
                case RIGHT:
                    j++;
                    if (j == J2) {
                        I1++;
                        d = DOWN;
                    }
                    break;
                case DOWN:
                    i++;
                    if (i == I2) {
                        J2--;
                        d = LEFT;
                    }
                    break;
                case LEFT:
                    j--;
                    if (j == J1) {
                        I2--;
                        d = UP;
                    }
                    break;
                case UP:
                    i--;
                    if (i == I1) {
                        J1++;
                        d = RIGHT;
                    }
                    break;
                    
            }
        }

        for (i = 0; i < A; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            res.add(row);
            for (j = 0; j < A; j++) {
                row.add(m[i][j]);
            }
        }        
        return res;
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
