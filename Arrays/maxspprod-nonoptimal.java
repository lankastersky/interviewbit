/*
MAXSPPROD

You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j. 

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9

https://www.interviewbit.com/problems/maxspprod/
*/

public class Solution {
    public int maxSpecialProduct(ArrayList<Integer> A) {
        int lf = 0;
        int rf = 0;
        int l = 0;
        int r = 0;
        long max = 0;
        for (int i = 0; i < A.size(); i++) {
            //int j = i - 1;
            boolean shrink = false;
            if (i > 0) {
                if (A.get(i) < A.get(i -1)) {
                    shrink = true;
                }
            }
            int j;
            // left
            if (!shrink || l == 0) {
                j = l;
                if (l == 0) {
                    j = i - 1;
                }
                while (j >= 0 && A.get(j) <= A.get(i)) {
                    j--;
                }
                if (j >= 0) {
                    l = j;
                } else {
                    l = 0;
                }
            } else {
                l = i - 1;
            }
            // right
            if (!shrink || r == 0) {
                j = r;
                if (r == 0) {
                    j = i + 1;
                }
                while (j < A.size() && A.get(j) <= A.get(i)) {
                    j++;
                }
                if (j < A.size()) {
                    r = j;
                } else {
                    r = 0;
                }
            } else {
                j = i + 1;
                while (j < A.size() && A.get(j) <= A.get(i)) {
                    j++;
                }
                if (j < A.size()) {
                    r = j;
                } else {
                    r = 0;
                }
            }
            //System.out.println("i:" + i + "(" + A.get(i) + ")" + ", l:" + l + ", r:" + r);
            if (l * r > max) {
                max = l * r;
                lf = l;
                rf = r;
                //System.out.println("max:" + max);
            }
        }
        return (int) (max % 1000000007);
    }
}
