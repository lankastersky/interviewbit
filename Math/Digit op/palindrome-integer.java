/*
Palindrome Integer

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

https://www.interviewbit.com/problems/palindrome-integer/
*/

public class Solution {
    public int isPalindrome(int A) {
        if (A < 0) {
            return 0;
        }
        
        int digits = 0;
        int d = A;
        while (d > 0) {
            digits++;
            d = d / 10;
        }
        int i = 0;
        while (i < digits) {
            int l = (A % (int) Math.pow(10, digits - i )) / (int) Math.pow(10, digits - i - 1);
            int r = (A % (int) Math.pow(10, i + 1)) / (int) Math.pow(10, i);
            i++;
            //System.out.println("l,r,A:" + l + ", " + r + ", " + A);
            if (l != r) {
                return 0;
            }
        }
        return 1;
    }
}
