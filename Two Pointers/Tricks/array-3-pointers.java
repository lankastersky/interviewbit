/*
Array 3 Pointers

You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
         
https://www.interviewbit.com/problems/array-3-pointers/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(
        final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int m = A.size();
        int n = B.size();
        int p = C.size();
        if (m * n * p == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0, k = 0; i < m && j < n && k < p;) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);
            int diff = Math.abs(a - b);
            diff = Math.max(diff, Math.abs(b - c));
            diff = Math.max(diff, Math.abs(a - c));
            res = Math.min(res, diff);
            if (a <= b && a <= c) {
                i++;
            } else if (b <= a && b <= c) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
