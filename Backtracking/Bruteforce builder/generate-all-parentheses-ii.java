/*
Generate all Parentheses II

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.

https://www.interviewbit.com/problems/generate-all-parentheses-ii/
*/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n < 1) {
            return res;
        }
        gen(res, new LinkedList<Character>(), n, 0, 0);
        return res;
    }
    
    void gen(ArrayList<String> res, LinkedList<Character> cur, int n, int opened, int closed) {
        if (cur.size() == n * 2) {
            res.add(build(cur));
            return;
        }
        if (opened < n) {
            cur.add('(');
            gen(res, cur, n, opened + 1, closed);
            cur.removeLast();
        }
        if (closed < opened) {
            cur.add(')');
            gen(res, cur, n, opened, closed + 1);
            cur.removeLast();
        }
    }
    
    String build(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character c: list) {
            sb.append(c);
        }
        return sb.toString();
    }
    // Generates ()))((()
    // void gen(Set<String> res, ArrayList<Integer> cur, int n, int sum) {
    //     if (cur.size() >= n - 1) {
    //         cur.add(sum);
    //         String s = build(cur);
    //         if (s.charAt(s.length() - 1) != '(') {
    //             res.add(s);
    //         }
    //         cur.remove(cur.size() - 1);
    //         return;
    //     }
    //     // if (cur.size() == n) {
    //     //     res.add(build(cur));
    //     //     return;
    //     // }
    //     for (int i = 0; i <= sum; i++) {
    //         cur.add(i);
    //         gen(res, cur, n, sum - i);
    //         cur.remove(cur.size() - 1);
    //     }
    // }
    
    // String build(ArrayList<Integer> cur) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < cur.size(); i++) {
    //         //System.out.print(cur.get(i) + " ");
    //         sb.append('(');
    //         for (int j = 0; j < cur.get(i); j++) {
    //             sb.append(')');
    //         }
    //     }
    //     //System.out.println();
    //     return sb.toString();
    // }

    // Can't generate (())(())
    // void gen(Set<String> res, StringBuilder sb, int n) {
    //     if (sb.length() == n * 2) {
    //         res.add(sb.toString());
    //         //sb.setLength(0);
    //         return;
    //     }
    //     sb.append("()");
    //     gen(res, sb, n);
    //     sb.setLength(sb.length() - 2);
        
    //     sb.insert(0, "()");
    //     gen(res, sb, n);
    //     sb.deleteCharAt(0);
    //     sb.deleteCharAt(0);
        
    //     sb.insert(0, '(');
    //     sb.append(')');
    //     gen(res, sb, n);
    //     sb.deleteCharAt(0);
    //     sb.deleteCharAt(sb.length() - 1);
    // }
}
