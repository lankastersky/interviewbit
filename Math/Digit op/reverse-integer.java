/*
Reverse integer

Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

https://www.interviewbit.com/problems/reverse-integer/
*/

public class Solution {
    public int reverse(int A) {
        int sign = 1;
        if (A < 0) {
            sign = -1;
            A = -A;
        }
        String s = String.valueOf(A);
        int n = s.length();
        char arr[] = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char t = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = t;
        }
        s = new String(arr);
        long res = Long.valueOf(s) * sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = 0;
        }
        return (int) res;
    }
}
