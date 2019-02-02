/*
Pascal Triangle

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

https://www.interviewbit.com/problems/pascal-triangle/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {
        if (A <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        res.add(a);        
        for (int i = 2; i <= A; i++) {
            ArrayList<Integer> prev = res.get(res.size() - 1);
            a = new ArrayList<>();
            res.add(a);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    a.add(1);
                } else {
                    a.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }
        return res;
    }
}
