/*
Highest Product

Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:

array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

https://www.interviewbit.com/problems/highest-product/
*/

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        if (A == null || A.size() < 3) {
            return 0;
        }
        Collections.sort(A);
        int n = A.size();
        int result = A.get(n - 1) * A.get(n - 2) * A.get(n - 3);
        if (A.get(0) < 0 && A.get(1) < 0) {
            result = Math.max(result, A.get(0) * A.get(1) * A.get(n - 1));
        }
        return result;
    }
}
