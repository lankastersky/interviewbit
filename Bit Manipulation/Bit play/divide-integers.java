/*
Divide Integers

Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Example:

5 / 2 = 2
Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

https://www.interviewbit.com/problems/divide-integers/
*/

public class Solution {
    // See also more optimal solution
    // https://stackoverflow.com/questions/5386377/division-without-using
    public int divide(int A, int B) {
        long a = A;
        long b = B;
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        long res = 0;
        int sign = 1;
        if (a < 0 && b < 0) {
            a = -a;
            b = -b;
        } else if (a < 0) {
            a = -a;
            sign = -1;
        } else if (b < 0) {
            b = -b;
            sign = -1;
        }
        while (a >= b) {
            a -= b;
            res++;
        }
        if (res * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
