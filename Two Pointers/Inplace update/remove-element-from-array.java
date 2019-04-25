/*
Remove Element from Array

Given an array and a value, remove all the instances of that value in the array. 
Also return the number of elements left in the array after the operation.
It does not matter what is left beyond the expected length.

 Example:
If array A is [4, 1, 1, 2, 1, 3]
and value elem is 1, 
then new length is 3, and A is now [4, 2, 3] 
Try to do it in less than linear additional space complexity.

https://www.interviewbit.com/problems/remove-element-from-array/
*/

public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        int n = a.size();
        
        long cur = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int el = a.get(i);
            if (el == b && cur == Long.MIN_VALUE) {
                cur = i;
                continue;
            }
            if (el != b && cur != Long.MIN_VALUE) {
                a.set((int) cur++, el);
            }
        }
        if (cur == Long.MIN_VALUE) {
            return n;
        }
        return (int) cur;
        // TLE
        // for (int i = n - 1; i >= 0; i--) {
        //     int el = a.get(i);
        //     if (el == b) {
        //         a.remove(i);
        //         n--;
        //         println(i + ":" + n);
        //     }
        // }
        //return n;
    }
    
    void println(String i) {
        //System.out.println(i + "");
    }
}
