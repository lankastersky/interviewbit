/*
Implement Power Function

Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.

https://www.interviewbit.com/problems/implement-power-function/
*/

public class Solution {
    public int pow(int x, int n, int d) {
        if (x == 0 && n == 0) {
            return 0;
        }
        if (n <= 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            x = (d - (-x % d)) % d;
        }
        x = x % d;
        long res = rpow(x, n, d);
        return (int) res;
    }
    
    long rpow(int x, int n, int d) {
        if (n == 1) {
            return x % d;
        }
        long res = rpow(x, n / 2, d);
        res = (res * res) % d;
        if (n % 2 == 1) {
            res = (res * x) % d;
        }
        //System.out.println("res, n: " + res + "," + n);
        return res;
    }
}
