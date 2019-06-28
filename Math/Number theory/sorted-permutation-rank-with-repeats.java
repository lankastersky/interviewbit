/*
Sorted Permutation Rank with Repeats

Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. 
Look at the example for more details.

Example :

Input : 'aba'
Output : 2

The order permutations with letters 'a', 'a', and 'b' : 
aab
aba
baa
The answer might not fit in an integer, so return your answer % 1000003

https://www.interviewbit.com/problems/sorted-permutation-rank-with-repeats/
*/

  public class Solution {
    int BASE = 1000003;

    // See https://en.wikipedia.org/wiki/Permutation#Permutations_with_repetition
    public int findRank(String A) {
      int N = A.length();
      long f[] = new long[N + 1];
      f[0] = 1;
      for (int i = 1; i <= N; i++) {
        f[i] = (f[i - 1] * i) % BASE;
      }

      TreeMap<Character, Integer> map = new TreeMap<>();
      for (char c: A.toCharArray()) {
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }
      long res = 0;
      for (int i = 0; i < N; i++) {
        char c = A.charAt(i);
        for (char ch: map.keySet()) {
          long remCombs = f[N - i - 1];
          if (ch < c && map.get(ch) > 0) {
            map.put(ch, map.get(ch) - 1);

            for (char ccur: map.keySet()) {
              int repeats = map.get(ccur);
              if (repeats == 0) {
                continue;
              }
              // https://en.wikipedia.org/wiki/Modular_multiplicative_inverse
              // (1/A) % MOD = A ^ (MOD - 2) % MOD
              //remCombs = remCombs / f[repeats];
              //long denom = (long) Math.pow(f[repeats], (BASE - 2)) % BASE;
              long denom = pow(f[repeats], BASE - 2);
              remCombs = (remCombs * denom) % BASE;
            }
            res = (res + remCombs) % BASE;

            map.put(ch, map.get(ch) + 1);
          }
        }

        map.put(c, map.get(c) - 1);
        println(String.format("i,c,pos,res:%d,%s,%d", i, c, res));
      }
      return (int) (res + 1);
    }

    void println(String s) {
      //System.out.println(s);
    }

    long pow(long a, long b) {
      if (a == 1) {
        return 1;
      }
      long p = 1;
//      for (int i = 0; i < b; i++) {
//        p = (p * a) % BASE;
//      }
      while (b > 0) {
        if (b % 2 == 1) {
          p = (p * a) % BASE;
        }
        a = (a * a) % BASE;
        b >>= 1;
      }
      return p;
    }
  
