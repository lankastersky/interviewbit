/*
You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Input :

Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
Output :

Return an Integer, i.e minimum number of steps.
Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
*/

public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int x = A.get(0);
        int y = B.get(0);
        int s = 0;
        int i = 1;
        int j = 1;
        while (i < A.size() &&  j < B.size()) {
            int x1 = A.get(i);
            int y1 = B.get(j);
            
            int cs = Math.max(Math.abs(x1 - x), Math.abs(y1 - y));
            s += cs;

            x = x1;
            y = y1;
            i++;
            j++;
        }
        return s;
    }
}
