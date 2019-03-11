/*
Kth Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3 ) :

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"
Given n and k, return the kth permutation sequence.

For example, given n = 3, k = 4, ans = "231"

 Good questions to ask the interviewer :
What if n is greater than 10. How should multiple digit numbers be represented in string?
 In this case, just concatenate the number to the answer.
so if n = 11, k = 1, ans = "1234567891011" 
Whats the maximum value of n and k?
 In this case, k will be a positive integer thats less than INT_MAX.
n is reasonable enough to make sure the answer does not bloat up a lot. 

https://www.interviewbit.com/problems/kth-permutation-sequence/
*/

public class Solution {
    
    public String getPermutation(int n, int k) {
        if (k * n == 0) {
            return "";
        }
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }       
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int pos = k - 1;
            for (int j = 1; j <= i; j++) {
                pos /= j;
            };
            //int pos = (k - 1) / fact(i); // Gives Divizion by zero
            int d = 0;
            int ind = 0;
            for (int el: set) {
                if (ind == pos) {
                    d = el;
                    break;
                }
                ind++;
            }
            res.append(String.valueOf(d));
            k = k - pos * fact(i);
            //System.out.println("pos,k,d:" + pos + "," + k + "," + d);
            set.remove(d);
        }
        return res.toString();
    }
    
    int fact(int n) {
        int res = 1;
        int i = 1;
        while (i <= n) {
            res *= i;
            i++;
        }
        return res;
    }
    
    // Doesn't work for n=60000, k=10^7
    // public String getPermutation(int n, int K) {
    //     long k = K;
    //     if (k * n == 0) {
    //         return "";
    //     }
        
    //     long memo[] = new long[n];
    //     int i = 1;
    //     memo[0] = 1;
    //     while (i < n) {
    //         memo[i] = memo[i - 1] * i;
    //         i++;
    //     }
    //     SortedSet<Integer> set = new TreeSet<>();
    //     for (i = 1; i <= n; i++) {
    //         set.add(i);
    //     }
    //     StringBuilder res = new StringBuilder();
    //     for (i = n - 1; i >= 0; i--) {
    //         long pos = (k - 1) / memo[i];
    //         int d = 0;
    //         int j = 0;
    //         for (int el: set) {
    //             if (j == pos) {
    //                 d = el;
    //                 break;
    //             }
    //             j++;
    //         }
    //         res.append(String.valueOf(d));
    //         k = k - pos * memo[i];
    //         //System.out.println("pos,k,d:" + pos + "," + k + "," + d);
    //         set.remove(d);
    //     }
    //     return res.toString();
    // }
    
    // Gives TLE
    // String gen(int n, int k, ArrayList<Integer> cur, Set<Integer> set) {
    //     if (cur.size() == n) {
    //         res++;
    //         if (res == k) {
    //             return build(cur);
    //         }
    //         return null;
    //     }
    //     for (int i = 1; i <= n; i++) {
    //         if (!set.contains(i)) {
    //             continue;
    //         }
    //         cur.add(i);
    //         set.remove(i);
    //         String s = gen();
    //         if (s != null) {
    //             return s;
    //         }
    //         set.add(i);
    //         cur.remove(cur.size() - 1);
    //     }
    //     return null;
    // }
    
    // String build(List<Integer> cur) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i: cur) {
    //         sb.append(String.valueOf(i));
    //     }
    //     return sb.toString();
    // }
}

