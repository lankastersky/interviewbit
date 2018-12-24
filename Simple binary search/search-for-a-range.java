/*
Search for a Range

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

https://www.interviewbit.com/problems/search-for-a-range/
*/

public class Solution {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = a.size();
        if (a.get(n - 1) < b) {
            res.add(-1);
            res.add(-1);
            return res;
        }
        
        Integer[] arr = a.toArray(new Integer[0]);

        // Finding the index of some B to use it later
        // int low = 0;
        // int high = n - 1;
        // int index = -1;
        // while (low <= high) {
        //     int mid = (low + high) / 2;
            
        //     if (arr[mid] == b) {
        //         index = mid;
        //         break;
        //     }
        //     if (arr[mid] < b) {
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //     }
        // }
        
        // if (index == -1) {
        //     res.add(-1);
        //     res.add(-1);
        //     return res;
        // }
        // int l = index - 1;
        // int r = index + 1;

        // Finding left boundary
        int first = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //System.out.println("l,h,m: " + low + "," + high + "," + arr[mid]);
            if (mid == 0 && arr[0] == b) {
                first = 0;
                break;
            }
            if (mid == n - 1) {
                if (arr[n - 1] == b) {
                    first = n - 1;
                    break;
                }
            } else if (arr[mid] != b && arr[mid + 1] == b) {
                first = mid + 1;
                break;
            }
            if (arr[mid] < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if (first == -1) {
            res.add(-1);
            res.add(-1);
            return res;            
        }
        //System.out.println("-");
        
        // Finding right boundary
        int last = -1;
        low = first;
        high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //System.out.println("l,h,m: " + low + "," + high + "," + arr[mid]);
            if (mid == n - 1) {
                if (arr[mid] == b) {
                    last = n - 1;
                    break;
                }
            } else if (arr[mid] == b && arr[mid + 1] != b) {
                last = mid;
                break;
            }
            if (arr[mid] <= b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        res.add(first);
        res.add(last);
        return res;
    }
}
