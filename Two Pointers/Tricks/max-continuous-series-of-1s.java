/*
Max Continuous Series of 1s

You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.

https://www.interviewbit.com/problems/max-continuous-series-of-1s/
*/

public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        if (A == null || A.isEmpty()) {
            return null;
        }
        int x = 0;
        int f1 = -1;
        int l1 = -1;
        int i = 0;
        int c1 = 0;
        int n = A.size();
        while (i < n) {
            // Find next 0
            while (i < n && A.get(i) != 0) {
                i++;
            }
            if (i == n) {
                if (f1 == -1) {
                    f1 = c1;
                    l1 = n - 1;
                }
                break;
            }
            int c0 = i;
            int c = c0;
            int M = B;
            // Flip zeros
            while (c < n && M >= 0) {
                if (A.get(c) == 0) {
                    if (M > 0) {
                        M--;
                    } else {
                        break;
                    }
                }
                c++;
            }
            // Calc 1s
            int num1 = c - c1;
            if (num1 > x) {
                x = num1;
                f1 = c1;
                l1 = c - 1;
            }
            // Move current pointer
            i++;
            // Update first 1 pointer
            c1 = i;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (i = f1; i <= l1; i++) {
            res.add(i);
        }
        return res;
    }
}

