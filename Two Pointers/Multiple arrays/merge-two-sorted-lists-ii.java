/*
Merge Two Sorted Lists II

Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]

https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
*/

public class Solution {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null || b == null) {
            return;
        }
        long n = a.size() + b.size();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (i < a.size() && j < b.size()) {
                if (a.get(i) <= b.get(j)) {
                    i++;
                    continue;
                }
                a.add(i, b.get(j));
                i++;
                j++;
            }
        }
        int lasta = a.get(a.size() - 1);
        while (j < b.size() && lasta > b.get(j)) {
            a.add(a.size() - 1, b.get(j));
            j++;
        }
        while (j < b.size()) {
            a.add(b.get(j));
            j++;
        }
    }
}
