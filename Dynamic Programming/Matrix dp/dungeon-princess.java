/*
Dungeon Princess

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of
M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way
through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms
are either empty (0’s) or contain magic orbs that increase the knight’s health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight’s minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path

RIGHT-> RIGHT -> DOWN -> DOWN.
-2(K) -3  3
-5    -10 -1
10    30  -5(P)
Dungeon Princess: Example 1

Input arguments to function:
Your function will get an M*N matrix (2-D array) as input which represents the 2D grid as described in the question. 
Your function should return an integer corresponding to the knight’s minimum initial health required. 

 Note:
The knight’s health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess 
is imprisoned.

https://www.interviewbit.com/problems/dungeon-princess/
*/

public class Solution {

    int INF = Integer.MIN_VALUE;
    
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        int m = A.get(0).size();
        int dp[][] = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            dp[i] = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                dp[i][j] = INF;
            }
        }
        dp[n][m - 1] = 0;
        dp[n - 1][m] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int req = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.min(0, req + A.get(i).get(j));
                println(i + "," + j + ":" + dp[i][j]);
            }
        }
        
        return 1 - dp[0][0]; 
    }     
    
    
    // Cool but complicated
    // int INF = Integer.MIN_VALUE;
    // public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
    //     int n = A.size();
    //     if (n == 0) {
    //         return 0;
    //     }
    //     int m = A.get(0).size();
    //     int dp[][] = new int[n + 1][];
    //     for (int i = 0; i <= n; i++) {
    //         dp[i] = new int[m + 1];
    //         for (int j = 0; j <= m; j++) {
    //             dp[i][j] = INF;
    //         }
    //     }
    //     dp[n][m - 1] = 0;
    //     dp[n - 1][m] = 0;
    //     for (int i = n - 1; i >= 0; i--) {
    //         for (int j = m - 1; j >= 0; j--) {
    //             int req = Math.min(dp[i + 1][j], dp[i][j + 1]);
    //             dp[i][j] = Math.max(0, req - A.get(i).get(j));
    //             /*
    //              If A[i][j] == 0, then nothing is gained in this cell; the player 
    //              can leave the cell with the same points as he enters the room with.
    //              If A[i][j] < 0, then the player must have points greater than 
    //              req before entering (i, j) in order to compensate for 
    //              the points lost in this cell. The minimum amount of compensation is
    //              req - A[i][j].
    //              If A[i][j] > 0, then the player could enter (i, j) with points 
    //              as little as req - A[i][j]. Since he could gain
    //              A[i][j]. points in this cell.  However, the value of req - A[i][j] 
    //              might drop to 0 or below in this situation.
    //              https://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
    //              */
    //             println(i + "," + j + ":" + dp[i][j]);
    //         }
    //     }
        
    //     return dp[0][0] + 1; 
    // } 
    
    
    // Fails on big test cases
    // long dp[][];
    // int n;
    // int m;
    // long INF = Long.MIN_VALUE;
    // public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
    //     n = A.size();
    //     if (n == 0) {
    //         return 0;
    //     }
    //     m = A.get(0).size();
    //     dp = new long[n][];
    //     for (int i = 0; i < n; i++) {
    //         dp[i] = new long[m];
    //         for (int j = 0; j < m; j++) {
    //             dp[i][j] = INF;
    //         }
    //     }
        
    //     long life = step(A, 0, 0);
    //     println("");
    //     long cur = A.get(0).get(0);
    //     int i = 0;
    //     int j = 0;
    //     long min = Math.min(cur, 0);
    //     while (i + 1 < n || j + 1 < m) {
    //         long right = INF;
    //         long bottom = INF;
    //         if (i + 1 < n) {
    //             bottom = dp[i + 1][j];
    //         }
    //         if (j + 1 < m) {
    //             right = dp[i][j + 1];
    //         }
    //         if (right > bottom) {
    //             j++;
    //         } else {
    //             i++;
    //         }
    //         cur += A.get(i).get(j);
    //         min = Math.min(min, cur);
    //         println(i + "," + j + ": " + min);
    //     }
    //     return (int) (1 - min);
    // }
    
    // long step(ArrayList<ArrayList<Integer>> A, int i, int j) {
    //     if (i == n || j == m) {
    //         return INF;
    //     }
    //     if (dp[i][j] != INF) {
    //         return dp[i][j];
    //     }
        
    //     int life = A.get(i).get(j);
    //     long res;
    //     if (i == n - 1 && j == m - 1) {
    //         res = life;
    //     } else {
    //         res = Math.max(
    //             step(A, i + 1, j),
    //             step(A, i, j + 1));
    //         res = res + life;
    //     }
    //     dp[i][j] = res;
    //     println(i + "," + j + ": " + res);
    //     return res;
    // }
    
    void println(String s) {
        //System.out.println(s);
    }
}
