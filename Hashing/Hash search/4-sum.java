/*
4 Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

 Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
Example : 
Given array S = {1 0 -1 0 -2 2}, and target = 0
A solution set is:

    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
    (-1,  0, 0, 1)
Also make sure that the solution set is lexicographically sorted.
Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR (Solution[i][0] == Solution[j][0] AND ... 
Solution[i][k] < Solution[j][k])

https://www.interviewbit.com/problems/4-sum/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = A.size();
        if (n < 4) {
            return res;
        }
        Collections.sort(A);
        Map<Integer, ArrayList<Integer>> valToInd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = A.get(i);
            ArrayList<Integer> ind;
            if (valToInd.containsKey(a)) {
                ind = valToInd.get(a);
            } else {
                ind = new ArrayList<>();
                valToInd.put(a, ind);
            }
            ind.add(i);
        }
        
        Integer prevA = null;
        Integer prevB = null;
        Integer prevC = null;
        for (int i = 0; i < n; i++) {
            int a = A.get(i);
            if (prevA != null && prevA == a) {
                continue;
            }
            prevA = a;
            for (int j = i + 1; j < n; j++) {
                int b = A.get(j);
                if (prevB != null && prevB == b) {
                    continue;
                }
                prevB = b;
                for (int k = j + 1; k < n; k++) {
                    int c = A.get(k);
                    if (prevC != null && prevC == c) {
                        continue;
                    }
                    prevC = c;
                    
                    int d = B - a - b - c;
                    if (valToInd.containsKey(d)) {
                        ArrayList<Integer> ind = valToInd.get(d);
                        if (ind.get(ind.size() - 1) <= k) {
                            continue;
                        }
                        ArrayList<Integer> cur = new ArrayList<>();
                        cur.add(a);
                        cur.add(b);
                        cur.add(c);
                        cur.add(d);
                        res.add(cur);
                    }
                }
            }
        }
        return res;
    }
}
