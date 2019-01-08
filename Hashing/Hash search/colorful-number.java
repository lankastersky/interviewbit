/*
Colorful Number

For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
Seen th

https://www.interviewbit.com/problems/colorful-number/
*/

public class Solution {
    public int colorful(int A) {
        if (A == 0) {
            return 1;
        }
        A = Math.abs(A);
        Map<Long, Boolean> map = new HashMap<>();
        ArrayList<Integer> d = digits(A);
        // for every substr find product and put to the map if possible
        for (int i = 0; i < d.size(); i++) {
            for (int j = i; j < d.size(); j++) {
                long p = 1;
                for (int k = i; k <= j; k++) {
                    p = p * d.get(k);
                }
                if (map.containsKey(p)) {
                    return 0;
                }
                map.put(p, true);
            }
        }
        return 1;
    }
    
    ArrayList<Integer> digits(int A) {
        ArrayList<Integer> x = new ArrayList<>();
        while (A != 0) {
            x.add(0, A % 10);
            A /= 10;           
        }
        return x;
    }
}
