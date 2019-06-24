/*
Capture Regions on Board

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

https://www.interviewbit.com/problems/capture-regions-on-board/
*/
public class Solution {
    final char X = 'X';
    final char O = 'O';
    final char V = 'V';
    int N;
    int M;
    public void solve(ArrayList<ArrayList<Character>> a) {
        N = a.size();
        M = a.get(0).size();
        for (int i = 0; i < N; i++) {
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    // boundary
                    dfs(a, i, j);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            ArrayList<Character> row = a.get(i);
            for (int j = 0; j < M; j++) {
                char c = row.get(j);
                switch (c) {
                    case O:
                        row.set(j, X);
                        break;
                    case V:
                        row.set(j, O);
                        break;
                }
            }
        }
    }
    
    void dfs(ArrayList<ArrayList<Character>> a, int i, int j) {
        if (i < 0 || i > N - 1 || j < 0 || j > M - 1) {
            // boundary
            return;
        }
        char c = a.get(i).get(j);
        switch (c) {
            case X:
            case V:
                return;
        }
        // c == O
        a.get(i).set(j, V);
        dfs(a, i - 1, j);
        dfs(a, i + 1, j);
        dfs(a, i, j - 1);
        dfs(a, i, j + 1);
    }
}
