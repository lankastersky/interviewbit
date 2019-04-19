/*
Matrix Median

Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.

https://www.interviewbit.com/problems/matrix-median/
*/

public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        int m = A.get(0).size();
        if (m == 0) {
            return 0;
        }
        
        int half = n * m / 2;
        
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (high + low) / 2;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += upperBound(A.get(i), mid);
            }
            println(low + "," + high + "," + mid + ": " + res);
            if (res > half) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
        
        // With extra memory
        // ArrayList<Integer> a = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         a.add(A.get(i).get(j));
        //     }
        // }
        // Collections.sort(a);
        // int res = a.get(a.size() / 2);
        // return res;
    }
    
    int upperBound(ArrayList<Integer> a, int val) {
        int n = a.size();
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) < val) {
                low = mid + 1;
            } else if (a.get(mid) > val) {
                high = mid - 1;
            } else {
                while(mid < n && a.get(mid) == val) {
                    mid++;
                }
                return mid;
            }
        }
        return low;
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }
    void println(String s) {
        //System.out.println(s);
    }
}
