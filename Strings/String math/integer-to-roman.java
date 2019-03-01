/*
Integer To Roman

Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"

https://www.interviewbit.com/problems/integer-to-roman/
*/

public class Solution {
    // 1333 - M CCC XXX III
    // 1444 - M CD XL IV
    // 1555 - M D L V
    // 1999 - M CM XC IX
    public String intToRoman(int A) {
        StringBuilder sb = new StringBuilder();
        if (A >= 1000) {
            int m = A / 1000;
            for (int i = 0; i < m; i++) {
                sb.append("M");
            }
            A %= 1000;
        }
        if (A >= 100) {
            int d = A / 100;
            parse(d, sb, 'M', 'D', 'C');
            A %= 100;
        }
        if (A >= 10) {
            int d = A / 10;
            parse(d, sb, 'C', 'L', 'X');
            A %= 10;
        }
        parse(A, sb, 'X', 'V', 'I');
        return sb.toString();
    }
    
    void parse(int d, StringBuilder sb, char ten, char five, char one) {
        if (d == 9) {
            sb.append(one);
            sb.append(ten);
        } else if (d >= 5) {
            d = d - 5;
            sb.append(five);
            for (int i = 0; i < d; i++) {
                sb.append(one);
            }
        } else if (d == 4) {
            sb.append(one);
            sb.append(five);
        } else {
            for (int i = 0; i < d; i++) {
                sb.append(one);
            }
        }
    }
}
