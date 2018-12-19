/*
Prime Sum

Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

https://www.interviewbit.com/problems/prime-sum/
*/

public class Solution {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= (int)(A / 2); i++) {
            if (prime(i) && prime(A - i)) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }
    
    boolean prime(int a) {
        if (a == 1) {
            return false;
        }
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
