/*
Intersection Of Sorted Arrays

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that
 appear more than once in both arrays should be included multiple times in the final output. 
 
 https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 */
 
 public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(
        final List<Integer> A, final List<Integer> B) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            int M = A.size();
            int N = B.size();
            if (M == 0 || N == 0) {
                return res;
            }
            int i = 0;
            int j = 0;
            while (i < M && j < N) {
                int a = A.get(i);
                int b = B.get(j);
                if (a == b) {
                    res.add(a);
                    i++;
                    j++;
                } else if (a < b) {
                    i++;
                } else {// a > b
                    j++;
                }
            }
            return res;
    }
}
