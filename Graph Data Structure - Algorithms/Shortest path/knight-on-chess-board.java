/*
Knight On Chess Board
Asked in:  
Goldman Sachs
Amazon
Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination
or not.

// ![Knight's movements on a chess board](http://i.imgur.com/lmKL4AU.jpg)

The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6

https://www.interviewbit.com/problems/knight-on-chess-board/
*/

public class Solution {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        x1--;
        y1--;
        x2--;
        y2--;
        boolean[][] visited = new boolean[N][];
        for (int i = 0; i < N; i++) {
            visited[i] = new boolean[M];
        }
        
        // This is an implementation of https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        // But it's not required as all edges have weight 1
        // int[][] distance = new int[N][];
        // for (int i = 0; i < N; i++) {
        //     distance[i] = new int[M];
        //     for (int j = 0; j < M; j++) {
        //         distance[i][j] = Integer.MAX_VALUE;
        //     }
        // }
        
        // PriorityQueue<Point> queue = new PriorityQueue<>(8, (Point p1, Point p2) -> {
        //     return distance[p1.x][p1.y] - distance[p2.x][p2.y];
        // });
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> queue2 = new LinkedList<>();
        queue.add(new Point(x1, y1));
        //distance[x1][y1] = 0;
        
        Point[] adj = new Point[] {
            new Point(-2, -1),
            new Point(-2, 1),
            new Point(-1, -2),
            new Point(-1, 2),
            new Point(1, -2),
            new Point(1, 2),
            new Point(2, -1),
            new Point(2, 1)
        };
        
        int res = -1;
        int steps = 0;
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (p.x == x2 && p.y == y2) {
                //res = distance[p.x][p.y];
                res = steps;
                break;
            }
            for (int i = 0; i < adj.length; i++) {
                Point step = adj[i];
                int x = p.x + step.x;
                int y = p.y + step.y;
                if (0 <= x && x < N) {
                    if (0 <= y && y < M) {
                        if (visited[x][y]) {
                            continue;
                        }
                        // int dist = distance[p.x][p.y] + 1;
                        // if (dist < distance[x][y]) {
                        //     distance[x][y] = dist;
                        // }
                        queue2.add(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            //visited[p.x][p.y] = true;
            if (queue.isEmpty()) {
                steps++;
                queue.addAll(queue2);
                queue2.clear();
            }
        }
        
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         print(distance[i][j]);
        //     }
        //     println();
        // }
        return res;
    }
    
    void print(int i) {
        // if (i == Integer.MAX_VALUE) {
        //     System.out.print("inf ");
        //     return;
        // }
        // System.out.print(i + " ");
    }
    void println() {
        // System.out.println();
    }
}
