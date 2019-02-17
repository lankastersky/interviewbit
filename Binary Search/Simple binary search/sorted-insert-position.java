/*
Sorted Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

https://www.interviewbit.com/problems/sorted-insert-position/
*/

public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int n = a.size();
        int low = 0;
        int high = n - 1;
        if (b < a.get(0)) {
            return 0;
        }
        if (b > a.get(n - 1)) {
            return n;
        }
        while (low <= high) {
            int ind = (low + high) / 2;
            int ans = a.get(ind);
            if (ans == b) {
                return ind;
            } else if (ans < b) {
                low = ind + 1;
            } else {
                high = ind - 1;
            }
        }
        return low;
    }
}
