/*
Rotated Sorted Array Search

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

https://www.interviewbit.com/problems/rotated-sorted-array-search/
*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        int n = a.size();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = a.get(i);
        // }
        
        // Find index of min element
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            if (a.get(start) <= a.get(end)) {
                min = start;
                break;
            }
            int mid = (end + start) / 2;
            int amid = a.get(mid);
            if (amid <= a.get((mid + n - 1) % n) 
                && amid <= a.get((mid + 1) % n)) {
                min = mid;
                break;
            }
            if (a.get(start) <= amid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        //System.out.println("min, amin: " + min + ", " + a.get(min));
        
        if (a.get(min) > b) {
            return -1;
        }
        if ((min > 0) && a.get(min - 1) < b) {
            return -1;
        } else if ((min == 0) && a.get(n - 1) < b) {
            return -1;
        }
        
        // Find index of b
        
        if (a.get(n - 1) >= b) { // b is on the right from min 
            start = min;
            end = n - 1;
        } else { // b is on the left from min
            start = 0;
            end = min;
        }
        
        while (start <= end) {
            //System.out.println("s, e: " + start + ", " + end);
            int mid = (end + start) / 2;
            int amid = a.get(mid);
            if (amid == b) {
                return mid;
            }
            if (amid < b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }        
        
        return -1;
    }
}
