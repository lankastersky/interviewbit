/*
3 Sum Zero

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)

https://www.interviewbit.com/problems/3-sum-zero/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Collections.sort(A);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cur = A.get(i);
            int s = 0;
            int e = n - 1;
            while (s < e && s < i && i < e) {
                int a = A.get(s);
                int b = A.get(e);
                int sum = cur + a + b;
                if (sum < 0) {
                    s++;
                } else if (sum > 0) {
                    e--;
                } else {
                    String key = String.format("%d_%d_%d", a, cur, b);
                    if (!set.contains(key)) {
                        set.add(key);
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(a);
                        arr.add(cur);
                        arr.add(b);
                        res.add(arr);
                    }
                    s++;
                    e--;
                }
            }
        }
        return res;
    }
}
