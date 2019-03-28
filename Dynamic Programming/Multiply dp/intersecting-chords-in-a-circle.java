/*
Intersecting Chords in a Circle

Given a number N, return number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

For example,

N=2
If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
{(1-2), (3-4)} and {(1-4), (2-3)}

So, we return 2.
Notes:

1 ≤ N ≤ 1000
Return answer modulo 109+7.

https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/
*/

public class Solution {
    int[] memo;
    int base = (int) (1e9 + 7);
    
    public int chordCnt(int A) {
        if (A <= 0) {
            return 1;
        }
        if (memo == null) {
            memo = new int[A + 1];
            for (int i = 0; i <= A; i++) {
                memo[i] = -1;
            }
        }
        if (memo[A] != -1) {
            return memo[A];
        }

        long res = 0;
        for (int i = 0; i < A; i++) {
            long res1 = chordCnt(i);
            long res2 = chordCnt(A - i - 1);
            //     println(String.format("%d, %d: %d + %d=%d", i, (A - i -1), res1, res2, res));
            long r = (res1 * res2) % base;
            res = (res + r) % base;
        }
        memo[A] = (int) res;    
        return memo[A];
    }
    
    void print(String s) {
        System.out.print(s + " ");
    }
    
    void println(String s) {
        System.out.println(s);
    }
}
