/*
Kth Row of Pascal's Triangle

Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
*/

public class Solution {
    public ArrayList<Integer> getRow(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        if (n == 0) {
            return res;
        }
        int c = 1;
        for (int i = 1; i < n; i++) {
            c = c * (n - i + 1) / i;
            res.add(c);
        }
        res.add(1);
        return res;
    }
}
