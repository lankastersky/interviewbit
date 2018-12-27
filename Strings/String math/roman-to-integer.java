/*
Roman To Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

https://www.interviewbit.com/problems/roman-to-integer/
*/

public class Solution {
    public int romanToInt(String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('i', 1);
        map.put('v', 5);
        map.put('x', 10);
        map.put('l', 50);
        map.put('c', 100);
        map.put('d', 500);
        map.put('m', 1000);
        String a = A.toLowerCase();
        int i = 0;
        int n = a.length();
        int result = 0;
        while (i < n) {
            char c = a.charAt(i);
            int d = map.get(c);
            if (i + 1 < n) {
                char c2 = a.charAt(i + 1);
                int d2 = map.get(c2);
                if (d2 > d) {
                    result -= d; 
                } else {
                    result += d;
                }
                i++;
            } else {
                result += d;
                break;
            }
            //System.out.println("c,r:" + c + "," + result);
        }
        return result;
    }
}
