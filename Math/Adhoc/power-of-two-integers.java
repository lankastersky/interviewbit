/*
Power Of Two Integers

Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. 
A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

https://www.interviewbit.com/problems/power-of-two-integers/
*/

public class Solution {
    public int isPower(int A) {
        if (A == 0) {
            return 0;
        }
        if (A == 1) {
            return 1;
        }
        // Use Sieve of Eratosthenes
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= Math.sqrt(A); i++) {
            boolean prime = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(i);
            }
        }
        // Factorize A
        Map<Integer, Integer> primesMap = new HashMap<>();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            int power = 0;
            while (A % prime == 0) {
                A /= prime;
                power++;
            }
            if (power > 0) {
                primesMap.put(prime, power);
            }
        }
        
        if (A != 1) { // Factorization of A has p^1
            return 0;
        }

        int maxPower = 0;
        for (int prime: primesMap.keySet()) {
            int power = primesMap.get(prime);
            maxPower = Math.max(maxPower, power);
            print(prime + "," + power);
        }

        // Check of powers in factorization have a common divisor > 1
        // If yes, return true
        for (int p: primes) {
            if (p > maxPower) {
                break;
            }
            boolean commonDiviser = true;
            for (int power: primesMap.values()) {
                if (power % p != 0) {
                    commonDiviser = false;
                    break;
                }
            }
            if (commonDiviser) {
                return 1;
            }
        }
        return 0;
    }
    
    void print(String i) {
        //System.out.print(i + " ");
    }
}
