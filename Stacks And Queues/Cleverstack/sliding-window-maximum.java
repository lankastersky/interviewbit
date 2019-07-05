/*
Sliding Window Maximum

A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the 
very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You
have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 

https://www.interviewbit.com/problems/sliding-window-maximum/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int w) {
        ArrayList<Integer> B = new ArrayList<>();
        int n = A.size();
        int l = Math.min(w, n);
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = l - 1; i >= 0; i--) {
            if (deque.isEmpty()) {
                deque.add(A.get(i));
                continue;
            }
            if (deque.peekFirst() <= A.get(i)) {
                deque.addFirst(A.get(i));
            }
        }
        B.add(deque.peekFirst());
        
        for (int i = l ; i < n; i++) {
            int el = A.get(i);
            if (deque.peekFirst().equals(A.get(i - w))) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < el) {
                deque.removeLast();
            }
            deque.addLast(el);
            B.add(deque.peekFirst());
        }
        
        return B;
    }    
    
    // Gives TLE. O(n log w)
    // public ArrayList<Integer> slidingMaximum(final List<Integer> A, int w) {
    //     ArrayList<Integer> B = new ArrayList<>();
    //     int n = A.size();
    //     ArrayList<Integer> sorted = new ArrayList<>();
    //     int l = Math.min(w, n);
    //     for (int i = 0; i < l; i++) {
    //         sorted.add(A.get(i));
    //     }
        
    //     Collections.sort(sorted);
    //     B.add(sorted.get(sorted.size() - 1));
        
    //     for (int i = l; i < n; i++) {
    //         int del = A.get(i - w);
    //         delete(sorted, del);
    //         if (sorted.isEmpty()) {
    //             B.add(A.get(i));
    //         } else {
    //             B.add(Math.max(sorted.get(sorted.size() - 1), A.get(i)));
    //         }
    //         update(sorted, A.get(i));
    //     }
    //     return B;
    // }
        
    // void delete(ArrayList<Integer> sorted, int del) {
    //     if (sorted.size() == 1) {
    //         sorted.clear();
    //         return;
    //     }
    //     int low = 0;
    //     int high = sorted.size() - 1;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (sorted.get(mid) == del) {
    //             sorted.remove(mid);
    //             break;
    //         }
    //         if (sorted.get(mid) < del) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    // }
    
    // void update(ArrayList<Integer> sorted, int el) {
    //     if (sorted.isEmpty()) {
    //         sorted.add(el);
    //         return;
    //     }
    //     int n = sorted.size(); 
    //     int low = 0;
    //     int high = n - 1;
    //     if (el < sorted.get(0)) {
    //         sorted.add(0, el);
    //         return;
    //     }
    //     if (el > sorted.get(n - 1)) {
    //         sorted.add(el);
    //         return;
    //     }
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (sorted.get(mid) == el) {
    //             sorted.add(mid, el);
    //             break;
    //         }
    //         if (sorted.get(mid) < el && mid < n - 1 && el < sorted.get(mid + 1)) {
    //             sorted.add(mid + 1, el);
    //             break;
    //         }
    //         if (sorted.get(mid) < el) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }
    // }
}
