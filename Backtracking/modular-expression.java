/*
Modular Expression

Implement pow(A, B) % C.

In other words, given A, B and C, 
find (AB)%C.

Input : A = 2, B = 3, C = 3
Return : 2 
2^3 % 3 = 8 % 3 = 2

https://www.interviewbit.com/problems/modular-expression/
*/

public class Solution {
    public int Mod(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }
        if (B % 2 == 0) {
            long y = Mod(A, B / 2, C);
            long x = (y * y) % C;
            if (x < 0) {
                x += C;
            }
            return (int) x;
        }
        long y = Mod(A, B - 1, C);
        long x = ((A % C) * (y % C)) % C;
        if (x < 0) {
            x += C;
        }
        return (int) x;
    }
}
