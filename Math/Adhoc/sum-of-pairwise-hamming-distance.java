/*
Sum of pairwise Hamming Distance

Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are 
different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Example

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8

https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    int BASE = 1000000007;
    public int hammingDistance(final List<Integer> A) {
        int N = A.size();
        long res = 0;
        for (int k = 0; k < 32; k++) {
            long ones = 0;
            long zeros = 0;
            for (int i = 0; i < N; i++) {
                int a = A.get(i);
                int bit = (a >> k) & 1;
                if (bit == 1) {
                    ones++;
                } else {
                    zeros++;
                }
                //println(String.format("a,0,1,res: %d,%d,%d,%d", a, zeros, ones, res));
            }
            res = (res + (ones * zeros)) % BASE;
        }
        res = (res * 2) % BASE;
        return (int) res;
    }
    
    // Gives TLE.
    // public int hammingDistance(final List<Integer> A) {
    //     int N = A.size();
    //     long res = 0;
    //     for (int i = 0; i < N; i++) {
    //         for (int j = i + 1; j < N; j++) {
    //             int a = A.get(i);
    //             int b = A.get(j);
    //             int x = a ^ b;
    //             int bits = 0;
    //             while (x != 0) {
    //                 if ((x & 1) == 1) {
    //                     bits++;
    //                 }
    //                 x = x >> 1;
    //             }
    //             println(String.format("a,b,x,bits: %d,%d,%d,%d", a, b, x, bits));
    //             res = (res + bits) % BASE;
    //         }
    //     }
    //     res = (res * 2) % BASE;
    //     return (int) res;
    // }
    
    void println(String s) {
        //System.out.println(s);
    }
}
