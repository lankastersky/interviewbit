/*
Longest Arithmetic Progression

Problem Setter: dhruvi Problem Tester: sneh_gupta
Find longest Arithmetic Progression in an integer array and return its length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression. Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
Examples
1) 1, 2, 3(All differences are equal to 1)
2) 7, 7, 7(All differences are equal to 0)
3) 8, 5, 2(Yes, difference can be negative too)

Samples
1) Input: 3, 6, 9, 12
Output: 4

2) Input: 9, 4, 7, 2, 10
Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))

https://www.interviewbit.com/problems/longest-arithmetic-progression/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        // diff - length
        HashMap<Integer, Integer>[] m = (HashMap<Integer, Integer>[]) new HashMap[n];
        int res = 1;
        for (int i = 1; i < n; i++) {
            m[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A.get(i) - A.get(j);
                if (m[j] != null && m[j].containsKey(diff)) {
                    m[i].put(diff, m[j].get(diff) + 1);
                } else {
                    m[i].put(diff, 2);
                }
            }
            for (Map.Entry<Integer, Integer> entry: m[i].entrySet()) {
                res = Math.max(res, entry.getValue());
                //System.out.print(entry.getKey() + "," + entry.getValue() + " ");
            }
            //System.out.println();
        }
        return res;
    }
}
