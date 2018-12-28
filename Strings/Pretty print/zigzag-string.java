/*
Zigzag String

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.

https://www.interviewbit.com/problems/zigzag-string/
*/

public class Solution {
    public String convert(String A, int B) {
        if (A == null || A.isEmpty() || B <= 0) {
            return "";
        }
        if (B == 1) {
            return A;
        }
        List<Integer>[] buckets = (List<Integer>[]) new List[B];
        for (int i = 0; i < B; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        int gs = 2 * B - 2;
        int n = (int) Math.ceil((float) A.length() / gs);
        //System.out.println("gs,n: " + gs + "," + n);
        for (int g = 0; g < n; g++) {
            buckets[0].add(gs * g);
            for (int i = 1; i < B - 1; i++) {
                if (gs * g + i < A.length()) {
                    buckets[i].add(gs * g + i);
                }
                if (gs * (g + 1) - i < A.length()) {
                    buckets[i].add(gs * (g + 1) - i);
                }
            }
            if (gs * g + B - 1 < A.length()) {
              buckets[B - 1].add(gs * g + B - 1);
            }
        }
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < B; i++) {
            //System.out.println();
            int j = 0;
            while (j < buckets[i].size()) {
                int ind = buckets[i].get(j++);
                //System.out.print(ind + " ");
                char c = A.charAt(ind);
                res.append(c);
            }
        }
        return res.toString();
    }
}
