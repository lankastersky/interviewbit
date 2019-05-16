/*
Rod Cutting

There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N. Now, there are M weak points
on this rod denoted by positive integer values(all less than N) A1, A2, …, AM. You have to cut rod at all these weak points.
You can perform these cuts in any order. After a cut, rod gets divided into two smaller sub-rods. Cost of making a cut is the 
length of the sub-rod in which you are making a cut.

Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different
sequences of cuts give same cost, return the lexicographically smallest.

Notes:

Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ,
ai < bi, or if no such i found, then n < m.
N can be upto 109.
For example,

N = 6
A = [1, 2, 5]

If we make cuts in order [1, 2, 5], let us see what total cost would be.
For first cut, the length of rod is 6.
For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
So, total cost is 6 + 5 + 4.

Cut order          | Sum of cost
(lexicographically | of each cut
 sorted)           |
___________________|_______________
[1, 2, 5]          | 6 + 5 + 4 = 15
[1, 5, 2]          | 6 + 5 + 4 = 15
[2, 1, 5]          | 6 + 2 + 4 = 12
[2, 5, 1]          | 6 + 4 + 2 = 12
[5, 1, 2]          | 6 + 5 + 4 = 15
[5, 2, 1]          | 6 + 5 + 2 = 13


So, we return [2, 1, 5].

https://www.interviewbit.com/problems/rod-cutting/
*/

public class Solution {
    long dp[][];
    int parent[][];
    long INF = Long.MAX_VALUE;
    // Map<String, ArrayList<Integer>> cutsMap = new HashMap<>();
    public ArrayList<Integer> rodCut(int N, ArrayList<Integer> A) {
        A.add(0, 0);
        A.add(N);
        int n = A.size();
        dp = new long[n + 1][];
        parent = new int[n + 1][];
        for (int i = 0; i <= n; i++) {
            dp[i] = new long[n + 1];
            parent[i] = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        cut(A, 0, n - 1, res);
        
        res.clear();
        buildAnswer(A, 0, n - 1, res);
        return res;
    }
    
    void buildAnswer(ArrayList<Integer> A, int left, int right, ArrayList<Integer> res) {
        if (left + 1 >= right) {
            return;
        }
        int i = parent[left][right];
        res.add(A.get(i));
        buildAnswer(A, left, i, res);
        buildAnswer(A, i, right, res);
    }
    
    long cut(ArrayList<Integer> A, int left, int right, ArrayList<Integer> cur) {
        if (left + 1 >= right) {
            return 0;
        }
        String key = String.format("%d_%d", left, right);
        
        if (dp[left][right] != -1) {
            // cur.clear();
            // cur.addAll(cutsMap.get(key));
            return dp[left][right];
        }
        long res = INF;
        int n = A.size();
        
        long price = A.get(right) - A.get(left);
        for (int i = left + 1; i < right; i++) {
            ArrayList<Integer> lA = new ArrayList<>();
            ArrayList<Integer> rA = new ArrayList<>();
            long l = cut(A, left, i, lA);
            long r = cut(A, i, right, rA);
            if (res > l + r) {
                res = l + r;
                parent[left][right] = i;
                // cur.clear();
                // cur.add(A.get(i));
                // cur.addAll(lA);
                // cur.addAll(rA);
            }
        }
        res += price;
        dp[left][right] = res;
        // cutsMap.put(key, new ArrayList<Integer>(cur));
        print(left + "," + right + ":" + res + "=");
        // for (long c: cur) {
        //     print(c + " ");
        // }
        println("");
        return res;
    }
    
    void print(String s) {
        //System.out.print(s);
    }
    void println(String s) {
        //System.out.println(s);
    }
}
