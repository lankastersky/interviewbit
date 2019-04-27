/*
Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers 
sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]

https://www.interviewbit.com/problems/combination-sum/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int K) {
        //Collections.sort(A);
        Set<Integer> sortedSet = new TreeSet<>(A);
        ArrayList<Integer> uniqueA = new ArrayList<>(sortedSet);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        gennext(uniqueA, K, res, new ArrayList<>(), 0);
        return res;
    }
    
    void gennext(ArrayList<Integer> A, int K, ArrayList<ArrayList<Integer>> res,
        ArrayList<Integer> cur, int start) {
        if (K == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < A.size(); i++) {
            int a = A.get(i);
            if (K - a < 0) {
                break;
            }
            cur.add(a);
            gennext(A, K - a, res, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}
