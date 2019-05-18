/*
Tushar's Birthday Party

Problem Setter: raghav_aggiwal Problem Tester: archit.rai
As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied 
if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar’s 
friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.
Input Format

Friends : List of integers denoting eating capacity of friends separated by space.
Capacity: List of integers denoting filling capacity of each type of dish.
Cost :    List of integers denoting cost of each type of dish.

Constraints:
1 <= Capacity of friend <= 1000
1 <= No. of friends <= 1000
1 <= No. of dishes <= 1000

Example:

Input:
    2 4 6
    2 1 3
    2 5 3

Output:
    14

Explanation: 
    First friend will take 1st and 2nd dish, second friend will take 2nd dish twice.  Thus, total cost = (5+3)+(3*2)= 14

https://www.interviewbit.com/problems/tushars-birthday-party/
*/

public class Solution {
    int INF = Integer.MAX_VALUE;
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(
        final List<Integer> friends, final List<Integer> dishes, final List<Integer> prices) {
        
        int res = 0;
        for (int friend: friends) {
            res += knapsack(friend, dishes, prices);
        }
        return res;
    }
    
    int knapsack(int K, List<Integer> w, List<Integer> v) {
        int m[] = new int[K + 1];
        m[0] = 0;
        int n = w.size();
        print(K + ":");
        for (int i = 1; i <= K; i++) {
            // Orig: m[i] = max(m[i - w[0]] + v[0], ...m[i - w[n - 1]] + v[n - 1])
            m[i] = INF;
            for (int j = 0; j < n; j++) {
                int wj = w.get(j);
                if (wj > i) {
                    continue;
                }
                m[i] = Math.min(m[i], m[i - wj] + v.get(j));
            }
            print(m[i] + " ");
        }
        println("");
        return m[K];
    }
    
    void println(String s) {
        //System.out.println(s);
    }

    void print(String s) {
        //System.out.print(s);
    }
    
}
