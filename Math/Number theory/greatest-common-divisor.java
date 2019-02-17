/*
Greatest Common Divisor

Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 
 NOTE : DO NOT USE LIBRARY FUNCTIONS 
 
 https://www.interviewbit.com/problems/greatest-common-divisor/
 */
 
 public class Solution {
    public int gcd(int A, int B) {
        if (A == 0 || B == 0) {
            return A != 0 ? A : B;
        }
        int a, b;
        if (A > B) {
            a = A;
            b = B;
        } else {
            a = B;
            b = A;
        }
        
        int p, q = -1;
        
        while (true) {
            p = a / b;
            q = a % b;
            if (q == 0) {
                break;
            }
            a = b;
            b = q;
        }
        return b;
    }
}
