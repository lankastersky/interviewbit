/*
3 Sum

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers.

Assume that there will only be one solution

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

https://www.interviewbit.com/problems/3-sum/
*/

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if (A == null || A.size() < 3) {
            return 0;
        }
        long res = Integer.MAX_VALUE - B;
        int a, b, c;
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n; i++) {
            a = A.get(i);
            int j = 0;
            if (j == i) {
                j++;
            }
            int k = n - 1;
            if (k == i) {
                k--;
            }
            while (j < n && k >= 0 && j < k) {
                b = A.get(j);
                c = A.get(k);
                long sum = a + b + c;
                if (Math.abs(B - sum) < Math.abs(B - res)) {
                    res = sum;
                }
                if (sum < B) {
                    j++;
                    if (j == i) {
                        j++;
                    }
                } else {
                    k--;
                    if (k == i) {
                        k--;
                    }
                }
            }
        }
        return (int) res;
    }
}
