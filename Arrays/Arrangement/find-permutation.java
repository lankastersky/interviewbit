/*
Find Permutation

Given a positive integer n and a string s consisting only of letters D or I, you have to find 
any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]

https://www.interviewbit.com/problems/find-permutation/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int N) {
        int min = 1;
        int L = A.length();
        if (L == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> a = new ArrayList<>(N + 1);
        for (int i = 0; i < N; i++) {
            a.add(0);
        }
        for (int i = 0; i < L; i++) {
            char c = A.charAt(i);
            if (c == 'I') {
                a.set(i, min++);
            }
        }
        a.set(L, min++);
        for (int i = L - 1; i >= 0; i--) {
            char c = A.charAt(i);
            if (c == 'D') {
                a.set(i, min++);
            }
        }
        return a;
    }
}
