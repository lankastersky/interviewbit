/*
NQueens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Seen this question in a real interview before

https://www.interviewbit.com/problems/nqueens/
*/

public class Solution {
    
    boolean[] r;
    boolean[] d;
    boolean[] dt;
    
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        if (a <= 0) {
            return null;
        }
        r = new boolean[a];
        d = new boolean[2*a-1];
        dt = new boolean[2*a-1];
        
        ArrayList<ArrayList<String>> x = new ArrayList<>();
        boolean[][] board = new boolean[a][a];
        for (int i = 0; i < a; i++) {
            board[i] = new boolean[a];
        }
        solve(a, x, board, 0);
        return x;
    }
    
    boolean solve(int a,
        ArrayList<ArrayList<String>> x,
        boolean[][] board,
        int col) {
            
        if (col == a) {
            return true;
        }
        
        for (int i = 0; i < a; i++) {
            if (r[i]) {
                continue;
            }
            
            int di = i + col;
            int dti = a - i + col - 1;
            if (d[di] || dt[dti]) {
                continue;
            }
            
            r[i] = true;
            d[di] = true;
            dt[dti] = true;
            board[i][col] = true;
            
            if (solve(a, x, board, col + 1)) {
                // store board
                x.add(boardToStr(board));
            }
            
            r[i] = false;
            d[di] = false;
            dt[dti] = false;
            board[i][col] = false;
        }
        return false;
    }
    
    ArrayList<String> boardToStr(boolean[][] board) {
        ArrayList<String> x = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                rowBuilder.append(board[i][j] ? "Q" : ".");
            }
            String row = rowBuilder.toString();
            x.add(row);
            //System.out.println(row);
        }
        //System.out.println("----");
        return x;
    }
}
