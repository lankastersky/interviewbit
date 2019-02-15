/*
Repeat and Missing Number Array

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

https://www.interviewbit.com/problems/repeat-and-missing-number-array/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        long n = arr.size();
        int A = 0;
        int B = 0;
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + arr.get(i));
        }
        long all_sum = ((1 + n) * n) / 2;
        long a_minus_b = sum - all_sum;
        
        sum = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            long j = arr.get(i); 
            sum = (j * j + sum);
            j = i + 1;
            sum2 = (j * j + sum2);
        }
        long a_add_b = (sum - sum2) / (a_minus_b);
        A = (int) ((a_add_b + a_minus_b) / 2);
        B = (int) ((a_add_b - a_minus_b) / 2);

        // Uses O(n) memory
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     set.add(i + 1);
        // }
        // for (int i = 0; i < n; i++) {
        //     int el = arr.get(i);
        //     if (set.contains(el)) {
        //         set.remove(el);
        //     } else {
        //       A = el;  
        //     }
        // }
        // B = set.iterator().next();
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(A);
        res.add(B);
        return res;
    }
}
