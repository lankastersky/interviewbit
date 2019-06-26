/*
Flip

You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation,
you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean 
change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform
the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple 
solutions, return the lexicographically smallest pair of L and R.

Notes:

Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

https://www.interviewbit.com/problems/flip/
*/

public class Solution {
    public ArrayList<Integer> flip(String A) {
        int N = A.length();
        ArrayList<Integer> res = new ArrayList<>();

        int l = -1;
        int r = -1;
        int lt = -1;
        long max = Integer.MIN_VALUE;
        long gmax = Integer.MIN_VALUE;
        long cur = 0;
        boolean all1 = true;
        // Based on Kadane's algorithm: we find a subarray with maxdiff between
        // the number of 0's and 1's
        for (int i = 0; i < N; i++) {
            char c = A.charAt(i);
            switch (c) {
                case '0':
                    cur = 1;
                    all1 = false;
                    break;
                case '1':
                    cur = -1;
                    break;
            }
            if (cur > max + cur) {
                lt = i;
            }
            max = Math.max(cur, max + cur);
            if (gmax < max) {
                l = lt;
                r = i;
            }
            gmax = Math.max(gmax, max);
            println("l,r,max,gmax: " + l + " " + r + " " + max + " " + gmax);
        }
        if (all1) {
            return res;
        }
        res.add(l + 1);
        res.add(r + 1);
        return res;
    }
    
    // Gives TLE.
    // public ArrayList<Integer> flip(String A) {
    //     int N = A.length();
    //     boolean all1 = true;
    //     int diff[] = new int[N]; // diff between |0| - |1|
    //     for (int i = 0; i < N; i++) {
    //         char c = A.charAt(i);
    //         switch (c) {
    //             case '0':
    //                 all1 = false;
    //                 if (i == 0) {
    //                     diff[i] = 1;
    //                 } else {
    //                     diff[i] = diff[i - 1] + 1;
    //                 }
    //                 break;
    //             case '1':
    //                 if (i == 0) {
    //                     diff[i] = -1;
    //                 } else {
    //                     diff[i] = diff[i - 1] - 1;
    //                 }
    //                 break;
    //         }
    //     }
        
    //     ArrayList<Integer> res = new ArrayList<>();
    //     if (all1) {
    //         return res;
    //     }
        
    //     int l = 0;
    //     int r = 0;
    //     int max = Integer.MIN_VALUE;
    //     for (int i = 0; i < N; i++) {
    //         for (int j = i; j < N; j++) {
    //             int d;
    //             if (i == 0) {
    //                 d = diff[j];
    //             } else {
    //                 d = diff[j] - diff[i - 1];
    //             }
    //             if (max < d) {
    //                 l = i;
    //                 r = j;
    //                 max = d;
    //             }
    //         }
    //     }
    //     res.add(l + 1);
    //     res.add(r + 1);
    //     return res;
    // }
    
    void println(String s) {
        //System.out.println(s);
    }
}
