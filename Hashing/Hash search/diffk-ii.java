/*
Diffk II

Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that 
A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.

https://www.interviewbit.com/problems/diffk-ii/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        
        Set<Integer> set = new HashSet<>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            int req1 = B + A.get(i);
            int req2 = A.get(i) - B;
            if (set.contains(req1) || set.contains(req2)) {
                return 1;
            }
            set.add(A.get(i));
        }
        
        // O(n log n)
        // Collections.sort(A, Collections.reverseOrder());
        // Set<Integer> set = new HashSet<>();
        // int n = A.size();
        // for (int i = 0; i < n; i++) {
        //     int req = B + A.get(i);
        //     if (set.contains(req)) {
        //         return 1;
        //     }
        //     set.add(A.get(i));
        // }
        return 0;
    }
}
