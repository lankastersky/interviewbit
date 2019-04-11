/*
Maximum Absolute Difference

You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

https://www.interviewbit.com/problems/maximum-absolute-difference/
*/

public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        int n = A.size();
        int max_sum = A.get(0) + 0;
        int min_sum = A.get(0) + 0;
        int max_diff = 0 - A.get(0);
        int min_diff = 0 - A.get(0);
        for (int i = 1; i < n; i++) {
            max_sum = Math.max(max_sum, A.get(i) + i);
            min_sum = Math.min(min_sum, A.get(i) + i);
            max_diff = Math.max(max_diff, i - A.get(i));
            min_diff = Math.min(min_diff, i - A.get(i));
        }
        
        return Math.max(max_sum - min_sum, max_diff - min_diff);
    }
}
