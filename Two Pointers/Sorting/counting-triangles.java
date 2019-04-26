/*
Counting Triangles

You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
Considering each array element Ai as the edge length of some line segment, count the number of triangles which you can 
form using these array values.

Notes:

You can use any value only once while forming each triangle. Order of choosing the edge lengths doesn’t matter. Any triangle
formed should have a positive area.

Return answer modulo 109 + 7.

For example,

A = [1, 1, 1, 2, 2]

Return: 4

https://www.interviewbit.com/problems/counting-triangles/
*/

public class Solution {
    int base = (int) 1e9 + 7;
    
    public int nTriang(ArrayList<Integer> A) {
        long res = 0;
        Collections.sort(A);
        int n = A.size();

        for (int i = 0; i < n; i++) {
             int a1 = A.get(i);
             int k = i + 2;
             for (int j = i + 1; j < n - 1; j++) {
                 int a2 = A.get(j);
                 for (; k < n; k++) {
                     int a3 = A.get(k);
                     if (a1 + a2 <= a3) {
                         break;
                     }
                 }
                 int temp = k - j - 1;
                 res = (res + temp) % base;
             }
        }

        // TLE
        // for (int i = 0; i < n; i++) {
        //     int a1 = A.get(i);
        //     int c = 1;
        //     while (i + 1 < n && a1 == A.get(i + 1)) {
        //         i++;
        //         c++;
        //     }
        //     // All edges are equal, adding f = c!/3!
        //     long f = 1;
        //     if (c > 2) {
        //         int cur = 4;
        //         while (cur <= c) {
        //             f = (f * cur++) % base;
        //         }
        //         res = (res + f) % base;
        //     }

        //     long temp = 0;            
        //     for (int j = i + 1; j < n; j++) {
        //         int a2 = A.get(j);
        //         for (int k = j + 1; k < n; k++) {
        //             int a3 = A.get(k);
        //             if (a1 + a2 <= a3) {
        //                 break;
        //             }
        //             temp = (temp + 1) % base;
        //         }
        //     }
            
        //     // one edge from equals, two others
        //     long temp2 = (temp * c) % base;
        //     res = (res + temp2) % base;

        //     if (c > 1) {
        //         // two edges from equals, one other
        //         int a2 = a1;
        //         temp = 0;
        //         for (int k = i + 1; k < n; k++) {
        //             int a3 = A.get(k);
        //             if (a1 + a2 <= a3) {
        //                 break;
        //             }
        //             temp = (temp + 1) % base;
        //         }
        //         // 2 edges are equal, adding temp2 = c!/2! * temp
        //         temp2 = (temp * f * 2) % base;
        //         res = (res + temp2) % base;
        //     }
        // }
        

        // TLE        
        // for (int i = 0; i < n; i++) {
        //     int a1 = A.get(i);
        //     for (int j = i + 1; j < n; j++) {
        //         int a2 = A.get(j);
        //         for (int k = j + 1; k < n; k++) {
        //             int a3 = A.get(k);
        //             if (a1 + a2 <= a3) {
        //                 break;
        //             }
        //             res = (res + 1) % base;
        //         }
        //     }
        // }
        
        return (int) res;
    }
}
