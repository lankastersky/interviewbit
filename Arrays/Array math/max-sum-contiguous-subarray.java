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
        int lf = 0;
        int rf = 0;
        
        for (int l = 1; l < A.size(); l++) {
            if (A.get(l) > sum + A.get(l)) {
                lf = l;
                rf = l;
            }
            sum = Math.max(A.get(l), sum + A.get(l));
            if (sum > result) {
                rf = l;
                //System.out.println("Result: " + sum + "; lf: " + lf + "; rf: " + rf);
            }
            result = Math.max(result, sum);
        }
        /*
        System.out.println("Size: " + A.size());
        System.out.println("lf:" + lf);
        System.out.println("rf:" + rf);
        System.out.println("Check");
        int s = 0;
        for (int i = lf; i < rf; i++) {
            System.out.print(A.get(i) + " ");
            s += A.get(i);
        }
        System.out.println("\n" + s);
        */
        return result;
    }
}
