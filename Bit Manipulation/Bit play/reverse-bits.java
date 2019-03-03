/*
Reverse Bits

Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long

https://www.interviewbit.com/problems/reverse-bits/
*/

public class Solution {
    public long reverse(long a) {
        int n = 32;
        long res = 0;
        int i = 0;
        while (i < n) {
            long b = (a & 1);
            res |= b;
            res = res << 1;
            a = a >> 1;
            i++;
        }
        return res >> 1;
    }
}
