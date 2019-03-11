/*
Largest Continuous Sequence Zero Sum

Find the largest continuous sequence in a array which sums to zero.

Example:


Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array. 
 
https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
*/

public class Solution {
    
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0) {
            return res;
        }
        // cumulative sum array
        int m[] = new int[n];
        m[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            m[i] = m[i - 1] + A.get(i);
        }
        int max = -1;
        int f = 0;
        int l = -1;
        for (int i = 0; i < n; i++) {
            if (m[i] == 0 && (i + 1) > max) {
                max = i + 1;
                f = 0;
                l = i;
            }
            for (int j = i + 1 + max; j < n; j++) {
                // sum of elements from A[i] to A[j] = m[j] - m[i-1]
                if (m[i] == m[j] && (j - i) > max) {
                    max = j - i;
                    f = i + 1;
                    l = j;
                }
            }
        }
        for (int i = f; i <= l; i++) {
            res.add(A.get(i));
        }
        return res;
    }

    // Gives OOM
    // public ArrayList<Integer> lszero(ArrayList<Integer> A) {
    //     int n = A.size();
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     if (n == 0) {
    //         return res;
    //     }
    //     int m[][] = new int[n][];
    //     for (int i = 0; i < n; i++) {
    //         m[i] = new int[n];
    //         m[i][i] = A.get(i);
    //     }
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             m[i][j] = m[i][j - 1] + A.get(j);
    //         }
    //     }
    //     int max = -1;
    //     int f = 0;
    //     int l = -1;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             if (m[i][j] == 0 && (j - i) > max) {
    //                 max = j - i;
    //                 f = i;
    //                 l = j;
    //             }
    //         }
    //     }
    //     for (int i = f; i <= l; i++) {
    //         res.add(A.get(i));
    //     }
    //     return res;
    // }
}
