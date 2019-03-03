/*

Asked in:  

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4

https://www.interviewbit.com/problems/single-number-ii/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int B = 32;
        int bits[] = new int[B];
        int n = A.size();
        for (int i = 0; i < n; i++) {
            int el = A.get(i);
            for (int j = 0; j < B; j++) {
                int b = el & 1;
                bits[j] += b;
                el >>= 1;
            }
        }
        int res = 0;
        for (int j = 0; j < B; j++) {
            int b = 0;
            if (bits[j] % 3 != 0) {
                b = 1;
            }
            res |= (b << j);
        }
        return res;
    }
}
