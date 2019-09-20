/*
Gray Code

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.

https://www.interviewbit.com/problems/gray-code/
*/

public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        if (a == 0) {
            return null;
        }
        ArrayList<Integer> x = new ArrayList<>();
        gen(a, x, 1);
        // for (int i: x) {
        //     System.out.print(i + " ");
        // }
        return x;
    }
    
    void gen(int a, ArrayList<Integer> x, int step) {
        if (a == step) {
            x.add(0);
            x.add(1);
            return;
        }
        
        gen(a, x, step + 1);
        for (int i = x.size() - 1; i >= 0; i--) {
            int el = x.get(i);
            int cur = (1 << step) | el;
            x.add(cur);
        }
    }
}
