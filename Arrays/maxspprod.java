/*
MAXSPPROD

You are given an array A containing N integers. The special product of each ith integer in this array is defined as the product of the following:<ul>

LeftSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (i>j). If multiple A[j]’s are present in multiple positions, the LeftSpecialValue is the maximum value of j. 

RightSpecialValue: For an index i, it is defined as the index j such that A[j]>A[i] (j>i). If multiple A[j]s are present in multiple positions, the RightSpecialValue is the minimum value of j.

Write a program to find the maximum special product of any integer in the array.

Input: You will receive array of integers as argument to function.

Return: Maximum special product of any integer in the array modulo 1000000007.

Note: If j does not exist, the LeftSpecialValue and RightSpecialValue are considered to be 0.

Constraints 1 <= N <= 10^5 1 <= A[i] <= 10^9

https://www.interviewbit.com/problems/maxspprod/
*/

public class Solution {
    static class Entity {
        final Integer value;
        final Integer index;
        Entity(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }
    public int maxSpecialProduct(ArrayList<Integer> A) {
        Stack<Entity> leftStack = new Stack<>();
        Stack<Entity> rightStack = new Stack<>();
        int[] leftp = new int[A.size()];
        int[] rightp = new int[A.size()];
        
        // buld left products
        for (int i = 0; i < A.size(); i++) {
            if (leftStack.empty()) {
                leftp[i] = 0;
            } else {
                Entity entity = leftStack.peek();
                while (!leftStack.empty() && entity.value <= A.get(i)) {
                    entity = leftStack.pop();
                }
                if (entity.value > A.get(i)) {
                    leftStack.push(entity);
                }
                if (leftStack.empty()) {
                    leftp[i] = 0;
                } else {
                    leftp[i] = entity.index;
                }
            }
            leftStack.push(new Entity(A.get(i), i));
        }
        
        // buld right products
        for (int i = A.size() - 1; i >= 0; i--) {
            if (rightStack.empty()) {
                rightp[i] = 0;
            } else {
                Entity entity = rightStack.peek();
                while (!rightStack.empty() && entity.value <= A.get(i)) {
                    entity = rightStack.pop();
                }
                if (entity.value > A.get(i)) {
                    rightStack.push(entity);
                }
                if (rightStack.empty()) {
                    rightp[i] = 0;
                } else {
                    rightp[i] = entity.index;
                }
            }
            rightStack.push(new Entity(A.get(i), i));
        }
        
        long max = 0;
        int maxi = -1;
        for (int i = 0; i < A.size(); i++) {
           //System.out.print("(" + leftp[i] + "," + rightp[i] + ") ");
            long p = leftp[i] * rightp[i];
            if (max < p) {
                max = p;
                maxi = i;
            }
        }
        
        return (int) (max % 1000000007L);
    }
}
