/*
Sort by Color

Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]

https://www.interviewbit.com/problems/sort-by-color/
*/

public class Solution {
    int R = 0;
    int W = 1;
    int B = 2;
    
    public void sortColors(ArrayList<Integer> a) {
        int cur = sc(a, R, 0);
        cur = sc(a, W, cur);
        cur = sc(a, B, cur);
    }
    
    int sc(ArrayList<Integer> a, int v, int start) {
        int n = a.size();
        int cur = start;
        for (int i = start; i < n; i++) {
            if (a.get(i) == v) {
                if (cur != i) {
                    int t = a.get(cur);
                    a.set(cur, a.get(i));
                    a.set(i, t);
                }
                cur++;
            }
        }
        return cur;
    }
}
