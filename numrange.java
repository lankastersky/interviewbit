/*
NUMRANGE

Given an array of non negative integers A, and a range (B, C), 
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :

A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3 
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

 NOTE : The answer is guranteed to fit in a 32 bit signed integer. 
 
 https://www.interviewbit.com/problems/numrange/
 */
 
 public class Solution {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        int x = 0;
        int n = A.size();
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A.get(i) > C) {
                continue;
            }
            sums.add(A.get(i));
            for (int j = i + 1; j < n; j++) {
                int prev = sums.get(sums.size() - 1);
                if (prev + A.get(j) > C) {
                    break;
                }
                sums.add(prev + A.get(j));
            }
        }
        
        for (Integer el: sums) {
            if (el >= B) {
                x++;
            }
        }
        return x;
    }
}
