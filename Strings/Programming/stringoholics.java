/*
Stringoholics

You are given an array A consisting of strings made up of the letters ‘a’ and ‘b’ only. 
Each string goes through a number of operations, where:
<ul>
<li>At time 1, you circularly rotate each string by 1 letter.</li>
<li>At time 2, you circularly rotate the new rotated strings by 2 letters.</li>
<li>At time 3, you circularly rotate the new rotated strings by 3 letters.</li>
<li>At time i, you circularly rotate the new rotated strings by i % length(string) letters.</li>
</ul>
Eg: String is abaa
<ul>
<li>At time 1, string is baaa, as 1 letter is circularly rotated to the back</li>
<li>At time 2, string is aaba, as 2 letters of the string baaa is circularly rotated to the back</li>
<li>At time 3, string is aaab, as 3 letters of the string aaba is circularly rotated to the back</li>
<li>At time 4, string is again aaab, as 4 letters of the string aaab is circularly rotated to the back</li>
<li>At time 5, string is aaba, as 1 letters of the string aaab is circularly rotated to the back</li>
</ul>
After some units of time, a string becomes equal to it’s original self. 
Once a string becomes equal to itself, it’s letters start to rotate from the first letter again (process resets). So, if a string takes t time to get back to the original, at time t+1 one letter will be rotated and the string will be it’s original self at 2t time. 
You have to find the minimum time, where maximum number of strings are equal to their original self. 
As this time can be very large, give the answer modulo 109+7.

Note: Your solution will run on multiple test cases so do clear global variables after using them.

Input:

A: Array of strings.
Output:

Minimum time, where maximum number of strings are equal to their original self.
Constraints:

1 <= size(A) <= 10^5
1 <= size of each string in A <= 10^5
Each string consists of only characters 'a' and 'b'
Summation of length of all strings <= 10^7
Example:

Input

A: [a,ababa,aba]
Output

4

String 'a' is it's original self at time 1, 2, 3 and 4.
String 'ababa' is it's original self only at time 4. (ababa => babaa => baaba => babaa => ababa)
String 'aba' is it's original self at time 2 and 4. (aba => baa => aba)

Hence, 3 strings are their original self at time 4.

https://www.interviewbit.com/problems/stringoholics/
*/

public class Solution {
    public int solve(ArrayList<String> A) {
        int n = A.size();
        if (n == 0) {
            return 0;
        }
        
        ArrayList<Integer> rotations = new ArrayList();
        for (int i = 0; i < n; i++) {
            rotations.add(rotation(A.get(i)));
            //System.out.print(rotations.get(i) + " ");
        }
        //System.out.println();
        
        //long curLCM = rotations.get(0);
        Map<Long, Long> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            //long temp = lcm(rotations.get(i), curLCM); 
            // if (temp < curLCM) {
            //     //System.out.println("SOF:" + i + "," + curLCM + "," + temp);
            // }
            // curLCM = temp;
            //System.out.print(curLCM + ",");
            long temp = rotations.get(i);
            factor(temp, map);
        }
        long res = 1;
        for (Long p: map.keySet()) {
            res = (res * pow(p, map.get(p))) % MOD;         
        }
        return (int) res;
        // return (int) (curLCM % MOD);
    }
    
    final long MOD = 1000000007;
    
    // long lcm(long a, long b) {
    //     Map<Long, Long> map = new HashMap<>();
    //     factor(a, map);
    //     factor(b, map);
    //     long res = 1;
    //     for (Long p: map.keySet()) {
    //         res = (res * (long) pow(p, map.get(p))) % MOD;
    //     }
    //     //System.out.println("a,b,f: " + a + "," + b + "," + res);
    //     return res;
    // }
    
    long pow(long p, long f) {
        long res = 1;
        int i = 1;
        while (i++ <= f) {
            res = (res * f) % MOD;
        }
        return res;
    }
    
    void factor(long a, Map<Long, Long> map) {
        long f;
        for (long p = 2; p <= Math.sqrt(a); p++) {
            f = 0;
            while (a % p == 0) {
                f++;
                a /= p;
            }
            if (f == 0) {
                continue;
            }
            if (map.containsKey(p)) {
                f = Math.max(map.get(p), f);
            }
            map.put(p, f);
        }
        if (a != 1) {
            f = 1;
            if (map.containsKey(a)) {
                f = Math.max(map.get(a), 1);
            }
            map.put(a, f);
        }
    }
    
    //Gives integer overflow    
    // long lcm(long a, long b) {
    //     long curGCD;
    //     if (a >= b) {
    //         curGCD = gcd(a, b);
    //     } else {
    //         curGCD = gcd(b, a);
    //     }
    //     double res = ((double) a * b);
    //     res = (res / curGCD);
    //     return (long) res;
    // } 

    // Gives Time limit exceeded    
    // int lcm(int a, int b) {
    //     int a0 = a;
    //     int b0 = b;
    //     long i = a;
    //     long j = b;
    //     while (i != j) {
    //         if (i < j) {
    //             i += a0;
    //         } else {
    //             j += b0;
    //         }
    //     }
    //     return (int) (i % MOD);
    // }
    
    // long gcd(long a, long b) {
    //     long q = a / b;
    //     long r = a % b;
    //     while (r != 0) {
    //         a = b;
    //         b = r;
    //         q = a / b;
    //         r = a % b;
    //     }
    //     return b;
    // }
    
    int rotation(String s) {
        long n = s.length();
        int res = 0;
        int l;
        long length = 1;
        int i = 1;
        while (length % n != 0) {
            if (length <= n / 2) {
                if (recurrent(s, (int) length)) {
                    return i;
                }
            }
            i++;
            length += i;
        }
        return i;
    }
    
    boolean recurrent(String s, int length) {
        int n = s.length();
        if (n % length != 0) {
            return false;
        }
        for (int i = length; i < n; i += length) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(j) != s.charAt(i + j)) {
                    return false;
                }
            }
        } 
        return true;        
    }
}
