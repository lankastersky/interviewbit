/*
Tushar's Birthday Bombs

It’s Tushar’s birthday today and he has N friends. Friends are numbered [0, 1, 2, …., N-1] and i-th friend have
a positive strength S(i). Today being his birthday, his friends have planned to give him birthday bombs (kicks :P). 
Tushar’s friends know Tushar’s pain bearing limit and would hit accordingly.
If Tushar’s resistance is denoted by R (>=0) then find the lexicographically smallest order of friends to kick Tushar
so that the cumulative kick strength (sum of the strengths of friends who kicks) doesn’t exceed his resistance capacity
and total no. of kicks hit are maximum. Also note that each friend can kick unlimited number of times (If a friend hits 
x times, his strength will be counted x times)

Note:

Answer format = Vector of indexes of friends in the order in which they will hit.
Answer should have the maximum no. of kicks that can be possibly hit. If two answer have the same no. of kicks,
return one with the lexicographically smaller.
[a1, a2, …., am] is lexicographically smaller than [b1, b2, .., bm] if a1 < b1 or (a1 = b1 and a2 < b2) … .
Input cases are such that the length of the answer does not exceed 100000.
Example:
R = 11, S = [6,8,5,4,7]

ans = [0,2]
Here, [2,3], [2,2] or [3,3] also give the maximum no. kicks.

https://www.interviewbit.com/problems/tushars-birthday-bombs/
*/

public class Solution {
    public ArrayList<Integer> solve(int R, ArrayList<Integer> S) {
        int n = S.size();
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        // Exclude too strong friends (mark as -1)
        int min = S.get(0);
        for (int el: S) {
            if (min > el) {
                min = el;
            }
        }    
        int size = R / min;
        for (int i = 0; i < n; i++) {
            int el = S.get(i);
            if (min * (size - 1) + el > R) {
                S.set(i, -1);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     System.out.print(S.get(i) + " ");
        // }
        // System.out.println();

        // Gives OOM, uses O(Rn) memory
        int[] m = new int[R + 1];
        ArrayList<Integer>[] friends = (ArrayList<Integer>[]) new ArrayList[R + 1];
        for (int i = 0; i <= R; i++) {
            m[i] = 0;
        }
        // unbounded knapsack problem, all values = 1
        // See https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm
        for (int w = min; w <= R; w++) {
            for (int j = 0; j < n; j++) {
                if (S.get(j) == -1) {
                    continue;
                }
                int wj = S.get(j);
                if (wj <= w) {
                    if (m[w] < 1 + m[w - wj]) {
                        m[w] = 1 + m[w - wj];
                        // add j-th element
                        if (friends[w - wj] != null) {
                            friends[w] = new ArrayList<>(friends[w - wj]);
                        } else {
                            friends[w] = new ArrayList<>();
                        }
                        friends[w].add(j);
                    }
                }
            }
        }
        if (friends[R] != null) {
            res = new ArrayList(friends[R]);
            Collections.sort(res);
        }
        
        return res;
    }
}
