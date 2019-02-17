/*
Trailing Zeros in Factorial

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1

https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
*/

public class Solution {
    /*
    25: 5, 15, 5*5
    35: 5, 15, 5*5, 35
    */
    public int trailingZeroes(int A) {
        int res = 0;
        
        int acc = 5;
        while (acc <= A) {
            res += A / acc;
            acc *= 5;
        }
        
        // O(n)
        // for (int i = 1; i <= A; i++) {
        //     res += fives(i);
        // }
        return res;
    }
    
    int fives(int a) {
        int res = 0;
        while (a % 5 == 0) {
            a /= 5;
            res++;
        }
        return res;        
    }
}
