/*
Queen Attack

On a N * M chessboard, where rows are numbered from 1 to N and columns from 1 to M, there are queens at some cells.
Return a N * M array A, where A[i][j] is number of queens that can attack cell (i, j). While calculating answer for cell (i, j), assume there is no queen at that cell.

Notes:

Queen is able to move any number of squares vertically, horizontally or diagonally on a chessboard. A queen cannot jump over
another queen to attack a position.
You are given an array of N strings, each of size M. Each character is either a 1 or 0 denoting if there is a queen at that
position or not, respectively.

Expected time complexity is worst case O(N*M).
For example,

Let chessboard be,
[0 1 0]
[1 0 0]
[0 0 1]

where a 1 denotes a queen at that position.

Cell (1, 1) is attacked by queens at (2, 1), (1,2) and (3,3).
Cell (1, 2) is attacked by queen at (2, 1). Note that while calculating this, we assume that there is no queen at (1, 2).
Cell (1, 3) is attacked by queens at (3, 3) and (1, 2).
and so on...

Finally, we return matrix
[3, 1, 2]
[1, 3, 3]
[2, 3, 0]

https://www.interviewbit.com/problems/queen-attack/
*/

 public class Solution {
     
    int di[] = new int[]{1, 0, -1, 0, 1, -1, -1, 1};
    int dj[] = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
    int K = 8;
    public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> A) {
        if (A.isEmpty()) {
            return new ArrayList<>();
        }
        int n = A.size();
        int m = A.get(0).length();
        ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
        int dp[][][] = new int[n][m][K];
        
        
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                res.get(i).add(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < K; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rec(i, j, k, A, res, dp);
                }
            }
        }
        
        return res;
    }

    int rec(int i, int j, int k, ArrayList<String> A, ArrayList<ArrayList<Integer>>  res, int dp[][][]) {
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int attacks = 0;
        int ni = i + di[k];
        int nj = j + dj[k];

        int n = A.size();
        int m = A.get(0).length();
        if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
            return 0;
        }
        if (A.get(ni).charAt(nj) == '1') {
            attacks++;
        } else {
            attacks = rec(ni, nj, k, A, res, dp);
        }
        res.get(i).set(j, res.get(i).get(j) + attacks);
        dp[i][j][k] = attacks;
        return attacks;
    }

// Too complicated.
//     public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> A) {
//         if (A.isEmpty()) {
//             return new ArrayList<>();
//         }
//         int n = A.size();
//         int m = A.get(0).length();
//         int rows[] = new int[n];
//         int cols[] = new int[m];
//         int mdiags[] = new int[n + m - 1];
//         int adiags[] = new int[n + m - 1];
        
//         ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             res.add(new ArrayList<>());
//             for (int j = 0; j < m; j++) {
//                 res.get(i).add(0);
//                 if (A.get(i).charAt(j) == '1') {
//                     rows[i]++;
//                     cols[j]++;
//                     mdiags[j + n - i - 1]++;
//                     adiags[i + j]++;
//                 }
//             }
//         }
        
//         // right
//         for (int i = 0; i < n; i++) {
//             int queen = A.get(i).charAt(0) == '1' ? 1 : 0;
//             int before = 0;
//             int after = rows[i] - queen;
//             calc(before, after, i, 0, res);
//             for (int j = 1; j < m; j++) {
//                 int nextqueen = A.get(i).charAt(j) == '1' ? 1 : 0;
//                 if (queen == 1) {
//                     before++;
//                 }
//                 if (nextqueen == 1) {
//                     after--;
//                 }
//                 calc(before, after, i, j, res);
//                 queen = nextqueen;
//             }
//         }
        
//         // down
//         for (int j = 0; j < m; j++) {
//             int queen = A.get(0).charAt(j) == '1' ? 1 : 0;
//             int before = 0;
//             int after = cols[j] - queen;
//             calc(before, after, 0, j, res);
//             for (int i = 1; i < n; i++) {
//                 int nextqueen = A.get(i).charAt(j) == '1' ? 1 : 0;
//                 if (queen == 1) {
//                     before++;
//                 }
//                 if (nextqueen == 1) {
//                     after--;
//                 }
//                 calc(before, after, i, j, res);
//                 queen = nextqueen;
//             }
//         }
        
//         // down-left
//         for (int d = 0; d < n + m - 1; d++) {
//             int i = 0;
//             int j = 0;
//             if (d >= m) {
//                 i = d - m + 1; 
//             }
//             if (d < m) {
//                 j = d;
//             } else {
//                 j = m - 1;
//             }
//             int queen = A.get(i).charAt(j) == '1' ? 1 : 0;
//             int before = 0;
//             int after = adiags[d] - queen;
//             calc(before, after, i, j, res);
//             i++;
//             j--;
//             while (i < n && j >= 0) {
//                 int nextqueen = A.get(i).charAt(j) == '1' ? 1 : 0;
//                 if (queen == 1) {
//                     before++;
//                 }
//                 if (nextqueen == 1) {
//                     after--;
//                 }
//                 calc(before, after, i, j, res);
//                 queen = nextqueen;
//                 i++;
//                 j--;
//             }
//         }
        
//         // down-right
//         for (int d = 0; d < n + m - 1; d++) {
//             int i = 0;
//             int j = 0;
//             if (d >= n) {
//                 i = 0; 
//             } else {
//                 i = n - d - 1;
//             }
//             if (d >= n) {
//                 j = d - n + 1;
//             }
//             int queen = A.get(i).charAt(j) == '1' ? 1 : 0;
//             int before = 0;
//             int after = mdiags[d] - queen;
//             calc(before, after, i, j, res);
//             i++;
//             j++;
//             while (i < n && j < m) {
//                 int nextqueen = A.get(i).charAt(j) == '1' ? 1 : 0;
//                 if (queen == 1) {
//                     before++;
//                 }
//                 if (nextqueen == 1) {
//                     after--;
//                 }
//                 calc(before, after, i, j, res);
//                 queen = nextqueen;
//                 i++;
//                 j++;
//             }
//         }

//         return res;
//     }
    
//     void calc(int before, int after, int i, int j, ArrayList<ArrayList<Integer>>  res) {
//         int attacks = 0;
//         if (before > 0) {
//             attacks++;
//         }
//         if (after > 0) {
//             attacks++;
//         }
//         int prevattacks = res.get(i).get(j);
//         res.get(i).set(j, prevattacks + attacks);
//     }
 }
