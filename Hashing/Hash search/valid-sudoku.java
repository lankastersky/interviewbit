/*
Valid Sudoku

Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

https://www.interviewbit.com/problems/valid-sudoku/
*/

public class Solution {
    int n = 9;
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        boolean rowhash[][] = new boolean[n][];
        boolean colhash[][] = new boolean[n][];
        for (int i = 0; i < n; i++) {
            rowhash[i] = new boolean[n];
            colhash[i] = new boolean[n];
        }
        boolean sectorhash[][][] = new boolean[3][][];
        for (int i = 0; i < 3; i++) {
            sectorhash[i] = new boolean[3][];
            for (int j = 0; j < 3; j++) {
                sectorhash[i][j] = new boolean[n];
            }
        }
        for (int i = 0; i < n; i++) {
            String row = A.get(i);
            for (int j = 0; j < n; j++) {
                char c = row.charAt(j);
                if (c == '.') {
                    continue;
                }
                int d = c - '0' - 1;
                if (rowhash[i][d] || colhash[j][d] || sectorhash[i / 3][j / 3][d]) {
                    return 0;
                }
                rowhash[i][d] = true;
                colhash[j][d] = true;
                sectorhash[i / 3][j / 3][d] = true;
            }
        }
        return 1;
    }
}
