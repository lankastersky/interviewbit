/*
Smallest sequence with given Primes

Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3
or a combination of them as their prime factors.

Example:

Input : 
Prime numbers : [2,3,5] 
k : 5

If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be: 

Output: 
{2,3,4,5,6}

Explanation : 
4 = p1 * p1 ( 2 * 2 )
6 = p1 * p2 ( 2 * 3 )

Note: The sequence should be sorted in ascending order

https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
*/

public class Solution {

    public ArrayList<Integer> solve(int A, int B, int C, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(A);
        set.add(B);
        set.add(C);
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            int min = set.pollFirst();
            res.add(min);
            set.add(min * A);
            set.add(min * B);
            set.add(min * C);
        }
        return res;
    }

    // too complex
    // public ArrayList<Integer> solve(int A, int B, int C, int k) {
    //     PriorityQueue<Integer> heap = new PriorityQueue<>();
    //     heap.add(A);
    //     heap.add(B);
    //     heap.add(C);
    //     TreeSet<Integer> res = new TreeSet<>();
    //     for (int i = 0; i < k; i++) {
    //         while (res.contains(heap.peek())) {
    //             heap.poll();
    //         }
    //         int min = heap.peek();
    //         res.add(min);
    //         print(min);
    //         for (int j: res) {
    //             heap.add(j);
    //         }
    //         heap.add(A * min);
    //         heap.add(B * min);
    //         heap.add(C * min);
    //     }
    //     return new ArrayList<>(res);
    // }
    
    void print(int i) {
        //System.out.print(i + " ");
    }
}
