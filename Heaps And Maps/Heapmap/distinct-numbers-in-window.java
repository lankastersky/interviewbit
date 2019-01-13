/*
Distinct Numbers in Window

You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].

https://www.interviewbit.com/problems/distinct-numbers-in-window/
*/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int K) {
        if (K > A.size()) {
            return new ArrayList<>();
        }
        int n = A.size();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> dup = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int size = set.size();
            set.add(A.get(i));
            Integer rep = dup.get(A.get(i));
            if (rep == null) {
                rep = 0;
            }
            dup.put(A.get(i), rep + 1);
        }
        res.add(set.size());
        for (int i = K; i < n; i++) {
            int remel = A.get(i - K);
            int dupel = dup.get(remel);
            if (dupel == 1) { // no repetitions of this element
                set.remove(remel);
            }
            dup.put(remel, dupel - 1);

            set.add(A.get(i));
            res.add(set.size());
            
            Integer rep = dup.get(A.get(i));
            if (rep == null) {
                rep = 0;
            }
            dup.put(A.get(i), rep + 1);
        }
        return res;
    }
}
