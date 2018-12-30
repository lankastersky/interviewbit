/*
Minimize the absolute difference

Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

https://www.interviewbit.com/problems/minimize-the-absolute-difference/
*/

public class Solution {
    public int solve(
        ArrayList<Integer> A, 
        ArrayList<Integer> B, 
        ArrayList<Integer> C) {
            
        if (A == null || B == null || C == null) {
            return 0;
        }
        if (A.isEmpty() || B.isEmpty() || C.isEmpty()) {
            return 0;
        }
        
        int res = mad(A.get(0), B.get(0), C.get(0));
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i + 1 < A.size()) || (j + 1 < B.size()) || (k + 1 < C.size())) {
            int ma = Integer.MAX_VALUE;
            int mb = Integer.MAX_VALUE;
            int mc = Integer.MAX_VALUE;
            if (i + 1 < A.size()) {
                ma = mad(A.get(i + 1), B.get(j), C.get(k));
            }
            if (j + 1 < B.size()) {
                mb = mad(A.get(i), B.get(j + 1), C.get(k));
            }
            if (k + 1 < C.size()) {
                mc = mad(A.get(i), B.get(j), C.get(k + 1));
            }
            int min = Math.min(Math.min(ma, mb), mc);
            if (min == ma) {
                i++;
            } else if (min == mb) {
                j++;
            } else {
                k++;
            }
            res = Math.min(res, min);
            // System.out.println("i,j,k: " + i + ", " + j + ", " + k);
            // System.out.println("ma,mb,mc,res: " + ma + ", " + mb + ", " + mc + ", " + res);
        }
        return res;
    }
    
    int mad(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        return Math.abs(max - min);
    }
}
