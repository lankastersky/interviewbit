/*
Palindrome Partitioning

Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")

Seen this question in a real interview beforeYesNo

https://www.interviewbit.com/problems/palindrome-partitioning/
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        if (a == null || a.isEmpty()) {
            return null;
        }
        ArrayList<ArrayList<String>> x = partition(a, 0);
        return x;
    }
    
    ArrayList<ArrayList<String>> partition(String a, int index) {
        ArrayList<ArrayList<String>> x = new ArrayList<>();
        int n = a.length();
        
        StringBuilder builder = new StringBuilder();
        for (int l = index; l < n; l++) {
            builder.append(a.charAt(l));
            String s = builder.toString(); 
            if (pal(s)) {
                if (l + 1 < n) {
                    ArrayList<ArrayList<String>> arrays = partition(a, l + 1);
                    for (ArrayList<String> arr: arrays) {
                        arr.add(0, s);
                        x.add(arr);
                    }
                } else {
                    ArrayList<String> arr = new ArrayList<>();
                    arr.add(s);
                    x.add(arr);
                }
            }
        }
        return x;
    }
    
    boolean pal(String s) {
        int n = s.length();
        if (n <= 1) {
            return true;
        }
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
