/*
Add One To Number

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

https://www.interviewbit.com/problems/add-one-to-number/
*/

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int buf = 1;
        int n = A.size();
        ArrayList<Integer> res = (ArrayList) A.clone();
        for (int i = n - 1; i >= 0; i--) {
            int el = A.get(i) + buf;
            if (el >= 10) {
                buf = 1;
                el -= 10;
                res.set(i, el);
            } else {
                buf = 0;
                res.set(i, el);
                break;
            }
        }
        if (buf == 1) {
            res.add(0, 1);
        }
        while (res.get(0) == 0) {
            res.remove(0);
        }
        return res;
    }
}

