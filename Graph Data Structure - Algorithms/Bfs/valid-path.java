/*
Valid Path

Problem Setter: glowing_glare Problem Tester: dhruvi
There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers 
are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without
touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the 
rectangle at any point of time.


Input Format

1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, number of circles.
4th argument given is an Integer R, radius of each circle.
5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
Constraints

0 <= x, y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid
For Example

Input:
    x = 2
    y = 3
    N = 1
    R = 1
    A = [2]
    B = [3]
Output:
    NO
   
Explanation:
    There is NO valid path in this case
    
https://www.interviewbit.com/problems/valid-path/
*/

public class Solution {
    String YES = "YES";
    String NO = "NO";
    char FREE = 0;
    char BUSY = 1;
    char FILL = 2;
    char[][] m;
    public String solve(
        int x, int y, int N, int R, ArrayList<Integer> X, ArrayList<Integer> Y) {
        
        if (N == 0) {
            return NO;
        }
        m = new char[x + 1][];
        for (int i = 0; i <= x; i++) {
            m[i] = new char[y + 1];
        }
        
        for (int i = 0; i < N; i++) {
            int a = X.get(i);
            int b = Y.get(i);
            fillCircle(a, b, R, x, y);
        }
        
        if (m[0][0] == BUSY) {
            return NO;
        }
        fillField(x, y);
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                print(m[i][j]);
            }
            println();
        }
        if (m[x][y] == FILL) {
            return YES;
        }
        return NO;
    }
    
    class Point {
        int a;
        int b;
        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    void fillField(int x, int y) {
        LinkedList<Point> queue = new LinkedList<>();
        m[0][0] = FILL;
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            int i = p.a;
            int j = p.b;
            
            // prev row
            if (i > 0) {
                if (j > 0 && m[i - 1][j - 1] == FREE) {
                    m[i - 1][j - 1] = FILL;
                    queue.add(new Point(i - 1, j - 1));
                }
                if (m[i - 1][j] == FREE) {
                    m[i - 1][j] = FILL;
                    queue.add(new Point(i - 1, j));
                }
                if (j < y && m[i - 1][j + 1] == FREE) {
                    m[i - 1][j + 1] = FILL;
                    queue.add(new Point(i - 1, j + 1));
                }
            }
            // cur row
            if (j > 0 && m[i][j - 1] == FREE) {
                m[i][j - 1] = FILL;
                queue.add(new Point(i, j - 1));
            }
            if (j < y && m[i][j + 1] == FREE) {
                m[i][j + 1] = FILL;
                queue.add(new Point(i, j + 1));
            }
            // next row
            if (i < x) {
                if (j > 0 && m[i + 1][j - 1] == FREE) {
                    m[i + 1][j - 1] = FILL;
                    queue.add(new Point(i + 1, j - 1));
                }
                if (m[i + 1][j] == FREE) {
                    m[i + 1][j] = FILL;
                    queue.add(new Point(i + 1, j));
                }
                if (j < y && m[i + 1][j + 1] == FREE) {
                    m[i + 1][j + 1] = FILL;
                    queue.add(new Point(i + 1, j + 1));
                }
            }
        }
        
    }
    
    void fillCircle(int a, int b, int R, int x, int y) {
        for (int i = a - R; i <= a + R; i++) {
            for (int j = b - R; j <= b + R; j++) {
                if (0 <= i && i <= x && 0 <= j && j <= y) {
                    if (distanceSq(i, j, a, b) <= R * R) {
                        m[i][j] = BUSY;
                    }
                }
            }
        }
    }
    
    long distanceSq(int a, int b, int x, int y) {
        return (a - x) * (a - x) + (b - y) * (b - y);
    }
    
    void print(int i) {
        //System.out.print(i + " ");
    }
    void println() {
        //System.out.println();
    }
}
