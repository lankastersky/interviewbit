/*
Kth Manhattan Distance Neighbourhood

Problem Setter: ishubansal Problem Tester: raghav_aggiwal
Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood for all 
elements in nxm matrix. 
In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.

Note: Expected time complexity is O(N*N*K)

Constraints:

1 <= n <= 300
1 <= m <= 300
1 <= K <= 300
0 <= M[i][j] <= 1000
Example:

Input:
M  = [[1,2,4],[4,5,8]] , K = 2

Output:
ans = [[5,8,8],[8,8,8]]

https://www.interviewbit.com/problems/kth-manhattan-distance-neighbourhood/
*/

public class Solution {

    public ArrayList<ArrayList<Integer>> solve(int K, ArrayList<ArrayList<Integer>> M) {
        int n = M.size();
        int m = M.get(0).size();
        
        // K - i - j
        ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();
        
        for (int k = 0; k <= K; k++) {
            ArrayList<ArrayList<Integer>> prevLevel = null;
            if (res.size() == 2) {
                res.remove(0);
            }
            if (k > 0) {
                prevLevel = res.get(0);
            }
            ArrayList<ArrayList<Integer>> level = new ArrayList<>();
            res.add(level);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                level.add(row);
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        row.add(M.get(i).get(j));
                        continue;
                    }
                    int val = prevLevel.get(i).get(j);
                    if (i > 0) {
                        val = Math.max(val, prevLevel.get(i - 1).get(j));
                    }
                    if (j > 0) {
                        val = Math.max(val, prevLevel.get(i).get(j - 1));
                    }
                    if (i + 1 < n) {
                        val = Math.max(val, prevLevel.get(i + 1).get(j));
                    }
                    if (j + 1 < m) {
                        val = Math.max(val, prevLevel.get(i).get(j + 1));
                    }
                    row.add(val);
                }
            }
        }
        return res.get(res.size() - 1);
    }
}
