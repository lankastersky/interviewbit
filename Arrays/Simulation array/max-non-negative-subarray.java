/*
Max Non Negative SubArray

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

https://www.interviewbit.com/problems/max-non-negative-subarray/
*/

public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long maxsum = -1;
        int maxs = -1;
        int maxe = -1;
        int i = 0;
        while (i < A.size()) {
            while (i < A.size() && A.get(i) < 0) {
                i++;
            }
            if (i == A.size()) {
                break;
            }
            int s = i;
            int e = -1;
            long sum = 0;
            while (i < A.size() && A.get(i) >= 0) {
                sum += A.get(i);
                e = i;
                i++;
            }
            if (sum > maxsum) {
                maxsum = sum;
                maxs = s;
                maxe = e;
            } else if (sum == maxsum) {
                if (e - s > maxe - maxs) {
                    maxsum = sum;
                    maxs = s;
                    maxe = e;
                } else if (e - s == maxe - maxs) {
                    if (A.get(s) < A.get(maxs)) {
                        maxsum = sum;
                        maxs = s;
                        maxe = e;
                    }
                }
            }
        }
        if (maxs != -1) {
            ArrayList<Integer> result = new ArrayList<>(A.subList(maxs, maxe + 1));
            return result;
        }
        return new ArrayList<Integer>();
    }
}
