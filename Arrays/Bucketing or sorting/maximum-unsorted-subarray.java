/*
Maximum Unsorted Subarray

You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.

https://www.interviewbit.com/problems/maximum-unsorted-subarray/
*/

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size();
        if (n == 0) {
            res.add(-1);
            return res;
        }
        int f = -1;
        int l = -1;
        for (int i = 0; i < n - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                f = i;
                break;
            }
        }
        if (f == -1) {
            res.add(-1);
            return res;
        }
        for (int i = n - 1; i > 0; i--) {
            if (A.get(i - 1) > A.get(i)) {
                l = i;
                break;
            }
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = f; i <= l; i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }
        
        for (int i = f; i >= 0; i--) {
            if (A.get(i) <= min) {
                break;
            }
            f = i;
        }
        
        for (int i = l; i < n; i++) {
            if (A.get(i) >= max) {
                break;
            }
            l = i;
        }
        res.add(f);
        res.add(l);
        
        // O(nlogn)
        // ArrayList<Integer> sorted = new ArrayList<>(A);
        // Collections.sort(sorted);
        // int f = -1;
        // int l = -1;
        // for (int i = 0; i < n; i++) {
        //     if (A.get(i) != sorted.get(i)) {
        //         if (f == -1) {
        //             f = i;
        //         }
        //         l = i;
        //     }
        // }
        
        // if (l != -1) {
        //     res.add(f);
        //     res.add(l);
        // } else {
        //     res.add(-1);
        // }
        return res;
    }
}
