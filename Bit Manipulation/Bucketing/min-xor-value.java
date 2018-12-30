/*
Min XOR value

Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

Examples : 
Input 
0 2 5 7 
Output 
2 (0 XOR 2) 
Input 
0 4 7 9 
Output 
3 (4 XOR 7)

Constraints: 
2 <= N <= 100 000 
0 <= A[i] <= 1 000 000 000

https://www.interviewbit.com/problems/min-xor-value/
*/

public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        if (A == null || A.size() < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i++) {
            int x = A.get(i) ^ A.get(i + 1);
            min = Math.min(x, min);
        }
        return min;
    }
}
