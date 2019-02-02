/*
Max Sum Contiguous Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
*/

/*
Solution based on Kadane's algorithm
https://en.wikipedia.org/wiki/Maximum_subarray_problem
*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int result = A.get(0);
        int sum = A.get(0);

        for (int l = 1; l < A.size(); l++) {
            sum = Math.max(A.get(l), sum + A.get(l));
            result = Math.max(result, sum);
        }
        return result;
    }
}
