/*
Nearest Smaller Element

Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10, 8]
Return : [-1, 4, -1, 2, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]

https://www.interviewbit.com/problems/nearest-smaller-element/
*/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return A;
        }
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (stack.isEmpty()) {
                x.add(-1);
                stack.push(A.get(i));
                continue;
            }
            int c = stack.pop();
            while (!stack.isEmpty() && c >= A.get(i)) {
                c = stack.pop();
            }
            stack.push(c);
            if (c < A.get(i)) {
                x.add(c);
            } else {
                x.add(-1);
            }
            stack.push(A.get(i));
        }
        return x;
    }
}
