/*
Excel Column Number

Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 

https://www.interviewbit.com/problems/excel-column-number/
*/

public class Solution {
    public int titleToNumber(String A) {
        Map<String, Integer> hex = new HashMap<>();

        hex.put("a", 1);
        hex.put("b", 2);
        hex.put("c", 3);
        hex.put("d", 4);
        hex.put("e", 5);
        hex.put("f", 6);
        hex.put("g", 7);
        hex.put("h", 8);
        hex.put("i", 9);
        hex.put("j", 10);
        hex.put("k", 11);
        hex.put("l", 12);
        hex.put("m", 13);
        hex.put("n", 14);
        hex.put("o", 15);
        hex.put("p", 16);
        hex.put("q", 17);
        hex.put("r", 18);
        hex.put("s", 19);
        hex.put("t", 20);
        hex.put("u", 21);
        hex.put("v", 22);
        hex.put("w", 23);
        hex.put("x", 24);
        hex.put("y", 25);
        hex.put("z", 26);
        
        int sum = 0;
        int mult = 1;
        for (int i = A.length() - 1; i >=0; i--) {
            String c = String.valueOf(A.charAt(i)).toLowerCase();
            sum = sum + mult * hex.get(c);
            mult *= 26;
        }
        return sum;
    }
}
