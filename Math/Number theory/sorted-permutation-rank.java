/*
Sorted Permutation Rank

Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003

https://www.interviewbit.com/problems/sorted-permutation-rank/
*/

public class Solution {
    
    final long BASE = 1000003;
    
    public int findRank(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        long cache[] = new long[n];
        int i = 1;
        cache[0] = 1;
        while (i < n) {
            cache[i] = (cache[i - 1] * (i + 1)) % BASE;
            i++;
        }
        
        Set<Character> set = new TreeSet<>();
        for (char c: s.toCharArray()) {
            set.add(c);
        }
        
        long res = 1;
        for (i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            int pos = getPos(set, c);
            set.remove(c);
            long f = cache[n - i - 2];
            res = (res + f * pos) % BASE;
            //System.out.println("c,pos,res:" + c + "," + pos + "," + res);
        }
        return (int) res;
    }
    
    int getPos(Set<Character> set, char c) {
        int i = 0;
        for (char s: set) {
            if (s == c) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
