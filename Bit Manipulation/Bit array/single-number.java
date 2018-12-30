/*
Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3

https://www.interviewbit.com/problems/single-number/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int n = A.size();
        int x = A.get(0);
        for (int i = 1; i < n; i++) {
            x ^= A.get(i);
        }
        return x;
    }
}
