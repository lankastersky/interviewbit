/*
Numbers of length N and value less than K

Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9

https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
*/

public class Solution {
    
    public int solve(ArrayList<Integer> A, int B, int C) {
        int numC = numDigits(C);
        if (B > numC || A.isEmpty()) {
            return 0;
        }
        if (numC > B) {
            // all possible combinations of B digits
            for (int i: A) {
                if (i == 0 && B != 1) {
                    return (A.size() - 1) * (int) Math.pow(A.size(), B - 1);
                }
            }
            return (int) Math.pow(A.size(), B);
        }

        Integer[] digit = new Integer[B];
        int CC = C;
        int i = 0;
        while (CC > 0) {
            digit[B - i - 1] = CC % 10;
            CC /= 10;
            i++;
        }
        // System.out.print("digit:");
        // for (i = 0; i < B; i++) {
        //     System.out.print(digit[i] + " ");
        // }
        // System.out.println();

        int[] lower = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (i = 0; i < 10; i++) {
            for (int a: A) {
                if (a < i) {
                    lower[i]++;
                }
            }
        }
        // System.out.println("lower:");
        // for (i = 0; i < 10; i++) {
        //     System.out.print(lower[i] + " ");
        // }
        // System.out.println();
        int[] dp = new int[B + 1];
        for (i = 0; i < B; i++) {
            dp[i] = 0;
        }
        int zeroesInA = 0;
        for (int a: A) {
            if (a == 0) {
                zeroesInA++;
            }
        }
        if (B != 1 && zeroesInA > 0) {
            dp[1] -= zeroesInA;
        }

        // Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
        boolean flag = true;
        
        for (i = 1; i <= B; i++) {
            // For all the Numbers whose First(i - 1) is less than First (i-1) of C, we can put
            // any digit at i-th index.
            {
                dp[i] += dp[i - 1] * A.size();
            }
            // For all the Numbers whose First (i - 1) is same as First (i - 1) of C, we can
            // only put those digits which are smaller than digit[i].

            if (flag || i == 1) {
                dp[i] += lower[digit[i - 1]];
            }
            if (!flag) {
                continue;
            }
            // Is digit[i - 1] present in A ?
            for (int j = 0; j < i; j++) {
                flag = false;
                for (int a: A) {
                    if (a == digit[i - 1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }
        return dp[B];
    }

    int numDigits(int C) {
        int numDigits = 0;
        int CC = C;
        while (CC > 0) {
            CC /= 10;
            numDigits++;
        }
        return numDigits;
    }
    
    // public int solve(ArrayList<Integer> A, int B, int C) {
    //     int[] n = new int[] {0};
    //     ArrayList<Integer> cur = new ArrayList<>();
    //     Map<Integer, Boolean> cached = new HashMap<>();
    //     int first = first(C, 1);
    //     for (int i = 0; i < A.size(); i++) {
    //         if (A.get(i) == 0 && B != 1) {
    //             continue;
    //         }
            
    //         if (A.get(i) >= C) {
    //             continue;
    //         }
            
    //         cur.add(i);
    //         calc(cur, A, B, C, n, cached);
    //         cur.remove(cur.size() - 1);
    //     }
    //     return n[0];
    // }
    
    // void calc(ArrayList<Integer> cur, ArrayList<Integer> A, int B, int C, int[] n, 
    //     Map<Integer, Boolean> cached) {
            
    //     int num = makeNumber(cur, A);
    //     // if (cached.get(num) != null) {
    //     //     return;
    //     // }
    //     cached.put(num, true);
    //     // for (int i = 0; i < cur.size(); i++) {
    //     //     System.out.print(A.get(cur.get(i)) + " ");
    //     // }
    //     // System.out.println("num:" + num);
    //     if (cur.size() == B) {
    //         if (num < C) {
    //             n[0]++;
    //         }
    //         return;
    //     }
    //     ArrayList<Integer> copyCur = new ArrayList<>(cur);
    //     int first = first(C, cur.size() + 1);
    //     // System.out.println("first:" + first);
    //     for (int i = 0; i < A.size(); i++) {
    //         cur.add(i);
    //         int number = makeNumber(cur, A);
    //         if (number < first) {
    //             calc(cur, A, B, C, n, cached);
    //         }
    //         cur.remove(cur.size() - 1);
    //     }
    // }
    
    // int makeNumber(ArrayList<Integer> cur, ArrayList<Integer> A) {
    //     StringBuilder s = new StringBuilder();
    //     for (int i = 0; i < cur.size(); i++) {
    //         s.append(A.get(cur.get(i)));
    //     }
    //     return Integer.valueOf(s.toString());
    // }
    
    // int first(int c, int i) {
    //     if (i == 0) {
    //         return 0;
    //     }
    //     int numbers = numDigits(c);
    //     if (numbers <= i) {
    //         return c;
    //     }
    //     return c / (int) Math.pow(10, numbers - i);
    // }
}
