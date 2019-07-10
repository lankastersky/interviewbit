/*
Min Jumps Array

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example :
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

If it is not possible to reach the end index, return -1.

https://www.interviewbit.com/problems/min-jumps-array/
*/

public class Solution {
    public int jump(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        if (A.get(0) == 0) {
            return -1;
        }
        int jumps = 1;
        int reachable = A.get(0);
        int prevreachable = A.get(0);
        for (int i = 1; i < n; i++) {
            int a = A.get(i);
            if (reachable < i) {
                return -1;
            }
            if (prevreachable < i) {
                jumps++;
                prevreachable = reachable;
            }
            reachable = Math.max(reachable, i + a);
        }
        return jumps;

        // Gives TLE
        // int reach[] = new int[n];
        // for (int i = 1; i < n; i++) {
        //     reach[i] = Integer.MAX_VALUE;
        // }
        // for (int i = 0; i < n; i++) {
        //     int a = A.get(i);
        //     int r = reach[i];
        //     if (r == Integer.MAX_VALUE) {
        //         return -1;
        //     }
        //     for (int j = 1; j <= a; j++) {
        //         if (i + j == n) {
        //             break;
        //         }
        //         reach[i + j] = Math.min(reach[i + j], r + 1);
        //     }
        //     for (int j = 0; j < n; j++) {
        //         print(reach[j]);
        //     }
        //     println();
        // }
        // return reach[n - 1] == Integer.MAX_VALUE ? -1 : reach[n - 1];
    }
    
    void print(int i) {
        System.out.print(i + " ");
    }
    void println(String s) {
        System.out.println(s);
    }
}
