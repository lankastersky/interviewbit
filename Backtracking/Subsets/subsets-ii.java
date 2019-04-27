/*
Subsets II

Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]

https://www.interviewbit.com/problems/subsets-ii/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        gennext(A, res, 0);
        return res;
    }
    
    void gennext(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, int start) {
        if (start == A.size()) {
            return;
        }
        ArrayList<Integer> prev = res.get(res.size() - 1);
        Integer last = null;
        for (int i = start; i < A.size(); i++) {
            if (A.get(i).equals(last)) {
                continue;
            }
            last = A.get(i);
            ArrayList<Integer> a = new ArrayList<>(prev);
            a.add(A.get(i));
            res.add(a);
            gennext(A, res, i + 1);
        }
    }
}
