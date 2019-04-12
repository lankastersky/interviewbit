/*
Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.

https://www.interviewbit.com/problems/largest-number/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        Collections.<Integer>sort(A, (a, b) -> {
            // doesn't work for 3 and 30
            //return -String.valueOf(a).compareTo(String.valueOf(b));
            String s1 = a.toString() + b.toString();
            String s2 = b.toString() + a.toString();
            long a1 = Long.valueOf(s1);
            long b1 = Long.valueOf(s2);
            return -Long.compare(a1, b1);
        });
        // for (int i = 0; i < A.size(); i++) {
        //     System.out.print(A.get(i) + " ");
        // }
        // System.out.println();
        
        StringBuilder result = new StringBuilder();
        boolean leadingNulls = true;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0 && leadingNulls) {
                continue;
            }
            leadingNulls = false;
            result.append(A.get(i).toString());
        }
        String resultString = result.toString();
        if (resultString.equals("")) {
            resultString = "0";
        }
        return resultString;
    }
}
