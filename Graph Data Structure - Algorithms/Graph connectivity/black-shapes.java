/*
Black Shapes

Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.

https://www.interviewbit.com/problems/black-shapes/
*/

public class Solution {
    public int black(ArrayList<String> A) {
        if (A.isEmpty()) {
            return 0;
        }
        int N = A.size();
        int M = A.get(0).length();
        int m[][] = new int[N][];
        for (int i = 0; i < N; i++) {
            m[i] = new int[M];
            for (int j = 0; j < M; j++) {
                m[i][j] = A.get(i).charAt(j) == 'X' ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    traverse(m, i, j, N, M);
                }
            }
        }
        return res;
    }
    
    void traverse(int m[][], int i, int j, int N, int M) {
        if (i < 0 || i >= N) {
            return;
        }
        if (j < 0 || j >= M) {
            return;
        }
        if (m[i][j] == 0) {
            return;
        }
        m[i][j] = 0;
        traverse(m, i - 1, j, N, M);
        traverse(m, i + 1, j, N, M);
        traverse(m, i, j - 1, N, M);
        traverse(m, i, j + 1, N, M);
    }
}
