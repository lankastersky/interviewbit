/*
Noble Integer
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.

https://www.interviewbit.com/problems/noble-integer/
*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) {
            return -1;
        }
        Collections.sort(A);
        for (int i = 0; i < n; i++) {
            if (i + 1< n) {
                if ((A.get(i) < A.get(i + 1)) && A.get(i) == n - i - 1) {
                    return 1;
                }
            } else if (A.get(i) == 0) {
                return 1;
            }
        }
        return -1;
    }
}
