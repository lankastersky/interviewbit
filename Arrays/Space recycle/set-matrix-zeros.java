/*
Set Matrix Zeros
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1

https://www.interviewbit.com/problems/set-matrix-zeros/
*/

public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        boolean[] rows = new boolean[a.size()];
        boolean[] columns = new boolean[a.get(0).size()];
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int r = 0; r < rows.length; r++) {
            if (rows[r]) {
                for (int j = 0; j < a.get(0).size(); j++) {
                    a.get(r).set(j, 0);
                }
            }
        }
        for (int c = 0; c < columns.length; c++) {
            if (columns[c]) {
                for (int i = 0; i < a.size(); i++) {
                    a.get(i).set(c, 0);
                }
            }
        }
    }
}
