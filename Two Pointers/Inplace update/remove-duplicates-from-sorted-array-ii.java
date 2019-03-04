/*
Remove Duplicates from Sorted Array II

Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].

https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
*/

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        if (n == 0) {
            return 0;
        }
        int res = 1;
        int prev = a.get(n - 1);
        int count = 1;
        int max = 2;
        for (int i = n - 2; i >= 0; i--) {
            int cur = a.get(i);
            if (prev == cur) {
                count++;
            } else {
                count = 1;
            }
            if (count == 1 || count == max) {
                res++;
            }
            if (count > max) {
                a.remove(i);
            }
            prev = cur;
        }
        return res;
    }
}
