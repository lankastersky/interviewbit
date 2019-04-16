/*
Largest Coprime Divisor

You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

A = 30
B = 12
We return
X = 5

https://www.interviewbit.com/problems/largest-coprime-divisor/
*/

public class Solution {
    
    public int cpFact(int A, int B) {
        int div = gcd(A, B);
        while (div != 1) {
            A = A / gcd(A, B);
            div = gcd(A, B);
        }
        return A;
    }

    int gcd(int A, int B) {
        if (A < B) {
            int t = A;
            A = B;
            B = t;
        }
        while (A % B != 0) {
            int t = A;
            A = B;
            B = t % B;
        }
        //System.out.println(B);
        return B;
    }
    
    // Give TLE
    // public int cpFact(int A, int B) {
    //     int max = (int) Math.max(Math.sqrt(A), Math.sqrt(B));
    //     ArrayList<Integer> primes = genPrimes(max);

    //     Map<Integer, Integer> aPrimesMap = fact(A, primes);
    //     Map<Integer, Integer> bPrimesMap = fact(B, primes);
        
    //     Set<Integer> aPrimes = aPrimesMap.keySet();
    //     Set<Integer> bPrimes = bPrimesMap.keySet();
        
    //     aPrimes.removeAll(bPrimes);
        
    //     int x = 1;
    //     for (int p: aPrimes) {
    //         int power = aPrimesMap.get(p);
    //         x *= Math.pow(p, power);
    //     }
    //     return x;
    // }
    
    // ArrayList<Integer> genPrimes(int max) {
    //     // Use Sieve of Eratosthenes
    //     ArrayList<Integer> primes = new ArrayList<>();
    //     for (int i = 2; i <= max; i++) {
    //         boolean prime = true;
    //         for (int j = 0; j < primes.size(); j++) {
    //             if (i % primes.get(j) == 0) {
    //                 prime = false;
    //                 break;
    //             }
    //         }
    //         if (prime) {
    //             primes.add(i);
    //         }
    //     }
    //     return primes;        
    // }
    
    // Map<Integer, Integer> fact(int A, ArrayList<Integer> primes) {
    //     // Factorize A
    //     Map<Integer, Integer> primesMap = new HashMap<>();
    //     for (int i = 0; i < primes.size(); i++) {
    //         int prime = primes.get(i);
    //         int power = 0;
    //         while (A % prime == 0) {
    //             A /= prime;
    //             power++;
    //         }
    //         if (power > 0) {
    //             primesMap.put(prime, power);
    //         }
    //         if (A == 1) {
    //             break;
    //         }
    //     }
    //     if (A != 1) {
    //         primesMap.put(A, 1);
    //     }
    //     return primesMap;
    // }
}
