/*
Diffk

Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that 
A[i] - A[j] = k, i != j.

 Example: Input : 
    A : [1 3 5] 
    k : 4
 Output : YES as 5 - 1 = 4 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

https://www.interviewbit.com/problems/diffk/
*/

public class Solution {
    public int diffPossible(ArrayList<Integer> A, int K) {
        int N = A.size();
        for (int i = 0; i < N; i++) {
            if (exists(A, K + A.get(i), i)) {
                return 1;
            }
        }
        return 0;
    }
    
    boolean exists(ArrayList<Integer> A, int K, int start) {
        int N = A.size();
        int i = start;
        int j = N - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if ((A.get(mid) == K) && (start < mid)) {
                return true;
            }
            if (A.get(mid) < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
