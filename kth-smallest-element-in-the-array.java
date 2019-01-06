/*
Kth Smallest Element in the Array

Find the kth smallest element in an unsorted array of non-negative integers.

Definition of kth smallest element

 kth smallest element is the minimum possible n such that there are at least k elements in the array <= n.
In other words, if the array A was sorted, then A[k - 1] ( k is 1 based, while the arrays are 0 based ) 
NOTE
You are not allowed to modify the array ( The array is read only ). 
Try to do it using constant extra space.

Example:

A : [2 1 4 3 2]
k : 3

answer : 2

https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
       // Based on method 2 from here
       // https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
        Queue<Integer> minheap = new PriorityQueue<>(A);
        for (int i = 1; i < B; i++) {
            minheap.poll();
        }
        return minheap.peek();
    }
    
    // Gives TLE
    // public int kthsmallest(final List<Integer> A, int B) {
    //     int[] mins = new int[B];
    //     int n = A.size();
    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < B; i++) {
    //         int min = -1;
    //         int minEl = Integer.MAX_VALUE;
    //         for (int j = 0; j < n; j++) {
    //             int el = A.get(j);
    //             if (el < minEl) {
    //                 if (i > 0) {
    //                     if (el >= mins[i - 1] && !set.contains(j)) {
    //                         min = j;
    //                         minEl = el;
    //                     }
    //                 } else {
    //                     min = j;
    //                     minEl = el;
    //                 }
    //             }
    //         }
    //         mins[i] = minEl;
    //         set.add(min);
    //     }
    //     // for (int i = 0; i < B; i++) {
    //     //     System.out.print(mins[i] + " ");
    //     // }
    //     // System.out.println();
    //     // System.out.print("set: ");
    //     // for (Integer el: set) {
    //     //     System.out.print(el + " ");
    //     // }
    //     // System.out.println();
    //     return mins[B - 1];
    // }
}
