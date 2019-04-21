/*
Valid Number

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem

https://www.interviewbit.com/problems/valid-number/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    enum State {
        UNKNOWN,
        SIGN,
        DECIMAL,
        POINT,
        FLOAT,
        EXP,
        EXP_DIGIT
    }
    
    String trim(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int j = n - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        if (j < i) {
            return "";
        }
        return s.substring(i, j + 1);
    }
    
    public int isNumber(final String A) {
        String s = trim(A);
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        char end = s.charAt(n - 1);
        if (!('0' <= end && end <= '9')) {
            return 0;
        }
        State state = State.UNKNOWN;
        for (char c: s.toCharArray()) {
            switch (state) {
                case UNKNOWN:
                    if (c == '-' || c == '+') {
                        state = State.SIGN;
                        break;
                    }
                    if ('0' <= c && c <= '9') {
                        state = State.DECIMAL;
                        break;
                    }
                    if (c == '.') {
                        state = State.POINT;
                        break;
                    }
                    return 0;
                case SIGN:
                    if ('0' <= c && c <= '9') {
                        state = State.DECIMAL;
                        break;
                    }
                    return 0;
                case DECIMAL:
                    if ('0' <= c && c <= '9') {
                        break;
                    }
                    if (c == '.') {
                        state = State.POINT;
                        break;
                    }
                    if (c == 'e') {
                        state = State.EXP;
                        break;
                    }
                    return 0;
                case POINT:
                    if ('0' <= c && c <= '9') {
                        state = State.FLOAT;
                        break;
                    }
                    return 0;
                case FLOAT:
                    if ('0' <= c && c <= '9') {
                        break;
                    }
                    if (c == 'e') {
                        state = State.EXP;
                        break;
                    }
                    return 0;
                case EXP:
                    if ('0' <= c && c <= '9') {
                        state = State.EXP_DIGIT;
                        break;
                    }
                    if (c == '-' || c == '+') {
                        state = State.EXP_DIGIT;
                        break;
                    }
                    return 0;
                case EXP_DIGIT:
                    if ('0' <= c && c <= '9') {
                        break;
                    }
                    return 0;
            }
        }

        return 1;
    }
}
