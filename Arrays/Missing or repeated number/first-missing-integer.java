/*
First Missing Integer

Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

https://www.interviewbit.com/problems/first-missing-integer/
*/

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int max = A.get(0);
        int min = 1;
        for (int i = 0; i < A.size(); i++) {
            if (max < A.get(i)) {
                max = A.get(i);
            }
        }
        if (max < 1) {
            max = 1;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(A.get(i), true);
        }
        for (int i = min; i <= max; i++) {
            if (map.get(i) == null) {
                return i;
            }
        }
        return max + 1;
    }
}
