/*
Sum Of Fibonacci Numbers

How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4 
so minimum numbers will be 2

https://www.interviewbit.com/problems/sum-of-fibonacci-numbers/
*/

public class Solution {
    Set<Integer> fib;
    //Map<Integer, Integer> memo = new HashMap<>();
    int memo[];
    public int fibsum(int A) {
        if (A <= 0) {
            return 0;
        }
        fib = new TreeSet<>();
        int a = 1;
        int b = 1;
        fib.add(a);
        while (b <= A) {
            fib.add(b);
            b = a + b;
            a = b - a;
        }

        // Gives OOM         
        // memo = new int [A + 1];
        // memo[0] = 0;
        // for (int i = 1; i <= A; i++) {
        //     memo[i] = i;
        //     for (int f: fib) {
        //         if (f > i) {
        //             break;
        //         }
        //         memo[i] = Math.min(memo[i], memo[i - f] + 1);
        //     }
        // }
        // return memo[A];

        return calc(A);
    }
    
    int calc(int A) {
        if (fib.contains(A)) {
            return 1;
        }
        if (A == 0) {
            return 0;
        }
        int res = 0;
        int prev = 1;
        for (Integer elem: fib) {
            if (elem >= A) {
                break;
            }
            prev = elem;
        }
        res = calc(A - prev) + 1;
        return res;
    }    

    // Gives OOM or Stack overflow    
    // int calc(int A) {
    //     if (fib.contains(A)) {
    //         return 1;
    //     }
    //     if (A < 1) {
    //         return Integer.MAX_VALUE;
    //     }
    //     // if (memo.containsKey(A)) {
    //     //     return memo.get(A);
    //     // }
    //     if (memo[A] != -1) {
    //         return memo[A];
    //     }
    //     int res = Integer.MAX_VALUE;
    //     for (Integer elem: fib) {
    //         if (elem > A) {
    //             break;
    //         }
    //         int l = calc(A - elem);
    //         res = Math.min(res, 1 + l);
    //     }
    //     //memo.put(A, res);
    //     memo[A] = res;
    //     //System.out.println("A,res: " + A + "," + res);
    //     return res;
    // }
}
