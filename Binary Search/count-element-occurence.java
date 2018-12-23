/*
Count Element Occurence

Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.

https://www.interviewbit.com/problems/count-element-occurence/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        int[] a = new int[A.size()];
        int i = 0;
        for (int el: A) {
            a[i++] = el;
        }
        int index = indexByBinarySearch(a, B);
        if (index == -1) {
            return 0;
        }
        int res = 1;
        int l = index - 1;
        int r = index + 1;
        while (l >= 0 && a[l--] == B) {
            res++;
        }
        while (r < A.size() && a[r++] == B) {
            res++;
        }
        return res;
    }
    
    int indexByBinarySearch(int[] a, int B) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (a[mid] == B) {
                return mid;
            }
            if (a[mid] < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
