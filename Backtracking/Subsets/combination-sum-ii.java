/*
Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate 
numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

https://www.interviewbit.com/problems/combination-sum-ii/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        Collections.sort(a);
        cs(x, b, a, 0, new ArrayList<>());
        return x;
    }
    
    void cs(ArrayList<ArrayList<Integer>> x, int b, ArrayList<Integer> a, int start, ArrayList<Integer> cur) {
        if (b == 0) {
            if (!x.isEmpty() && x.get(x.size() - 1).equals(cur)) {
                return;                
            }
            x.add(new ArrayList<>(cur));
            return;
        }
        if (b < 0) {
            return;
        }
        for (int i = start; i < a.size(); i++) {
            int el = a.get(i);
            cur.add(el);
            cs(x, b - el, a, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
