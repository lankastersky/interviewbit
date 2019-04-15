/*
Max Distance

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)

https://www.interviewbit.com/problems/max-distance/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        int res = 0;
        ArrayList<Integer> mins = new ArrayList<>();
        ArrayList<Integer> inds = new ArrayList<>();
        mins.add(A.get(0)); // stores mins for A[0:i]
        inds.add(0); // stores indices of mins
        for (int i = 1; i < n; i++) {
            int prevmin = i;
            for (int j = mins.size() - 1; j >= 0; j--) {
                if (mins.get(j) > A.get(i)) {
                    if (j == mins.size() - 1) {
                        mins.add(A.get(i));
                        inds.add(i);
                    }
                    break;
                }
                prevmin = inds.get(j);
            }
            res = Math.max(res, i - prevmin);
        }
        
        // Gives TLE.
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (A.get(i) <= A.get(j)) {
        //             res = Math.max(res, j - i);
        //         }
        //     }
        // }
        return res;
    }
}
