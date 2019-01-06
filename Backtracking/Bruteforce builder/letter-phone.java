/*
Letter Phone

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below:

http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.

https://www.interviewbit.com/problems/letter-phone/
*/

public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        if (A == null || A.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Doesn't compile
        //List<Character> letters = Chars.asList(A.toCharArray());
        // List<Character> letters = A.chars()
        //     .mapToObj(e->(char)e)
        //     .collect(Collectors.toList());
        
        // List<Character> letters = new ArrayList<>();
        // for (char c: A.toCharArray()) {
        //     letters.add(c);
        // }
        // Collections.sort(letters);
        // String s = letters.toString().replaceAll("[,\\s\\[\\]]", "");
        
        Map<Character, Set<Character>> map = new HashMap<>();
        map.put('0', new HashSet<>(Arrays.asList(
            new Character[]{'0'})));
        map.put('1', new HashSet<>(Arrays.asList(
            new Character[]{'1'})));
        map.put('2', new HashSet<>(Arrays.asList(
            new Character[]{'a', 'b', 'c'})));
        map.put('3', new HashSet<>(Arrays.asList(
            new Character[]{'d', 'e', 'f'})));
        map.put('4', new HashSet<>(Arrays.asList(
            new Character[]{'g', 'h', 'i'})));
        map.put('5', new HashSet<>(Arrays.asList(
            new Character[]{'j', 'k', 'l'})));
        map.put('6', new HashSet<>(Arrays.asList(
            new Character[]{'m', 'n', 'o'})));
        map.put('7', new HashSet<>(Arrays.asList(
            new Character[]{'p', 'q', 'r', 's'})));
        map.put('8', new HashSet<>(Arrays.asList(
            new Character[]{'t', 'u', 'v'})));
        map.put('9', new HashSet<>(Arrays.asList(
            new Character[]{'w', 'x', 'y', 'z'})));
        
        ArrayList<String> x = new ArrayList<>();
        combination(A, x, "", 0, map);
        return x;
    }
    
    void combination(String A, 
        ArrayList<String> x, 
        String last, 
        int step,
        Map<Character, 
        Set<Character>> map) {
            
        if (last.length() == A.length()) {
            x.add(last);
            return;
        }
        
        Character prevDigit = null;
        for (int i = step; i < A.length(); i++) {
            char digit = A.charAt(i);
            if (prevDigit != null && digit == prevDigit) {
                continue;
            }
            prevDigit = digit;
            
            Set<Character> set = map.get(digit);
            if (set == null) {
                return;
            }
            for (char letter: set) {
                String cur = last + letter;
                combination(A, x, cur, i + 1, map);
            }
        }
    } 
}
