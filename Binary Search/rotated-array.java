/*
Rotated Array

Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

https://www.interviewbit.com/problems/rotated-array/
*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int n = a.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = a.get(i);
        }
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            if (arr[start] <= arr[end]) {
                return arr[start];
            }
            int mid = (end + start) / 2;
            if (arr[mid] <= arr[(mid + n - 1) % n] && arr[mid] <= arr[(mid + 1) % n]) {
                return arr[mid];
            }
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }
}
