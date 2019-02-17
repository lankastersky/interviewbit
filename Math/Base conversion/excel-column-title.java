/*
Excel Column Title
Asked in:  
Amazon
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

https://www.interviewbit.com/problems/excel-column-title/
*/

public class Solution {
    public String convertToTitle(int A) {
        char base = 26;
        int q = A;
        StringBuilder res = new StringBuilder();
        while (q != 0) {
            char t = (char) ((q - 1) % base);
            char c = (char) ('A' + t);
            res.insert(0, c);
            q = (q - 1) / base;
        }
        return res.toString();
    }
}
