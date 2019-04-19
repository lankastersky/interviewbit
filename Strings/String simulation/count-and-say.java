/*
Count And Say

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

https://www.interviewbit.com/problems/count-and-say/
*/

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int reps = 1;
                while ((j + 1 < s.length()) && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                    reps++;
                }
                sb.append(reps);
                sb.append(s.charAt(j));
                println(i + "," + j + ": " + sb.toString());
            }
            s = sb.toString();
        }
        return s;
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
