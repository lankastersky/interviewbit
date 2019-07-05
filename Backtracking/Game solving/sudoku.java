/*
Sudoku

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.' 
You may assume that there will be only one unique solution.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

https://www.interviewbit.com/problems/sudoku/
*/

public class Solution {
    int n = 9;
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        Integer m[][] = new Integer[n][];
        boolean b[][] = new boolean[n][];
        for (int i = 0; i < n; i++) {
            m[i] = new Integer[n];
            b[i] = new boolean[n];
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < n; j++) {
                char c = row.get(j);
                if (c != '.') {
                    int d = c - '0' - 1;
                    m[i][j] = d;
                    b[i][d] = true;
                }
            }
        }
        
        solve(m, 0, 0, b);
        
        for (int i = 0; i < n; i++) {
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < n; j++) {
                char c = row.get(j);
                if (c == '.') {
                    row.set(j, (char) (m[i][j] + 1 + '0'));
                }
            }
        }
    }
    
    boolean solve(Integer m[][], int row, int col, boolean b[][]) {
        if (row > 0 && row % 3 == 0) { // 3 rows are filled out
            if (!valid(m, row - 3)) {
                return false;
            }
            if (row == n) {
                return true;
            }
        }

        Integer colGap = null;
        for (int c = col; c < n; c++) {
            if (m[row][c] == null) {
                colGap = c;
                break;
            }
        }
        if (colGap == null) {// all row is filled out
            return solve(m, row + 1, 0, b);
        }

        for (int j = 0; j < n; j++) {
            if (!b[row][j]) { // digit j is free in the row
                // check if digit is free by column
                boolean freeByCol = true;
                for (int i = 0; i < n; i++) {
                    if (m[i][colGap] != null && m[i][colGap] == j) {
                        freeByCol = false;
                        break;
                    }
                }
                if (!freeByCol) {
                    continue;
                }
                m[row][colGap] = j;
                b[row][j] = true; // mark digit as taken 
                if (solve(m, row, colGap, b)) {
                    return true;
                }
                b[row][j] = false; // mark digit as free
                m[row][colGap] = null;
            }
        }
        return false;
    }
    
    // check submatrices from rows [row; row + 3]
    boolean valid(Integer m[][], int row) {
        for (int col = 0; col < n; col += 3) {
            if (!validSubMatrix(m, row, col)) {
                return false;
            }
        }
        return true;
    }
    
    // check submatrix from rows [row; row + 3] and columns [col; col + 3]
    boolean validSubMatrix(Integer m[][], int row, int col) {
        println("Checking " + row + " " + col);
        boolean b[] = new boolean[n];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (m[i][j] == null || b[m[i][j]]) {
                    return false;
                }
                b[m[i][j]] = true;
            }
        }
        return true;
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
