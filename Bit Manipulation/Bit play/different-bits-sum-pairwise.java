/*
Different Bits Sum Pairwise

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, 
since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, 
j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) + 
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8

https://www.interviewbit.com/problems/different-bits-sum-pairwise/
*/

public class Solution {
    int BASE = 1000000007;
    public int cntBits(ArrayList<Integer> A) {
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
}

