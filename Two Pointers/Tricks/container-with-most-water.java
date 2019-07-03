/*
Container With Most Water

Given n non-negative integers a1, a2, ..., an,
where each represents a point at coordinate (i, ai).
'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).

 Note: You may not slant the container. 
Example :

Input : [1, 5, 4, 3]
Output : 6

Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3. 
So total area = 3 * 2 = 6

https://www.interviewbit.com/problems/container-with-most-water/
*/

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        int n = A.size();
        int x = 0;
        
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int h = Math.min(A.get(start), A.get(end));
            x = Math.max(x, (end - start) * h);
            if (A.get(start) < A.get(end)) {
                start++;
            } else {
                end--;
            }
        }
        
        // This works but not optimal
        // Stack<Integer> lefts = new Stack<>();        
        // for (int i = 0; i < n; i++) {
        //     int a = A.get(i);
        //     if (!lefts.isEmpty() && a <= lefts.peek()) {
        //         continue;
        //     }
        //     lefts.push(a);
        //     for (int j = i + 1; j < n; j++) {
        //         int b = A.get(j);
        //         x = Math.max(x, Math.min(a, b) * (j - i));
        //     }
        // }        
        
        // Gives TLE.
        // for (int i = 0; i < n; i++) {
        //     int a = A.get(i);
        //     for (int j = i + 1; j < n; j++) {
        //         int b = A.get(j);
        //         x = Math.max(x, Math.min(a, b) * (j - i));
        //     }
        // }
        return x;
    }
}
