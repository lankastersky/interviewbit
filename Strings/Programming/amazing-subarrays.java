/*
Amazing Subarrays

You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
  
  https://www.interviewbit.com/problems/amazing-subarrays/
*/

public class Solution {
    public int solve(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int n = A.length();
        Character[] charsArr = new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> chars = new HashSet<>(Arrays.asList(charsArr));
        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (chars.contains(c)) {
                res = (res + (n - i)) % 10003;
            }
        }
        return res;
    }
}
