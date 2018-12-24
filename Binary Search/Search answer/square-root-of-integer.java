/*
Square Root of Integer

Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3

https://www.interviewbit.com/problems/square-root-of-integer/
*/

public class Solution {
    public int sqrt(int a) {
        int digits = numDigits(a);
        // if (digits % 2 == 0) {
        //     int high = 0;
        //     int acc = 1;
        //     for (int i = 1; i <= digits / 2; i++) {
        //         high += 9 * acc;
        //         acc *= 10;
        //     }
        //     int low = high / 9;
        // } else {
            
        // }
        
        if (a == 0) {
            return 0;
        }
        
        long low, high;
        if (digits == 1) {
            low = 1;
            high = 4;
        } else {
            low = (int) Math.pow(10, digits / 2 - 1);
            high = (int) Math.pow(10, digits / 2 + 1);
        }
        long res = 0;
        while (low <= high) {
            //System.out.println("l,h: " + low + "," + high);
            long mid = ((low + high) / 2L);
            res = mid;
            if (res * res <= a && (res + 1) * (res + 1) > a) {
                return (int) res;
            }
            if (mid * mid < a) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return (int) res;
    }
    
    int numDigits(int a) {
        int res = 0;
        while (a > 0) {
            res++;
            a /= 10;
        }
        return res;
    }
    
    // Time Limit Exceeded
    // public int sqrt(int a) {
    //     int square = 0;
    //     while (square * square < a) {
    //         square++;
    //     }
    //     if (square * square > a) {
    //         square--;
    //     }
    //     return square;
    // }
}
