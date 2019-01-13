/*
Ways to form Max Heap

Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than 
the value present in it’s children nodes. If you want to know more about Heaps, please visit this link

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last,
is completely filled, and all nodes are as far left as possible. )
Every node is greater than all its children
Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

Following are the possible max heaps from these 4 numbers :

         4 
       /  \ 
      3   2 
     / 
    1
         4 
       /  \ 
      2   3 
     / 
    1
        4 
       /  \ 
      3   1 
     / 
    2
These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.

As the final answer can be very large output your answer modulo 1000000007

Input Constraints : n <= 100

https://www.interviewbit.com/problems/ways-to-form-max-heap/
*/

public class Solution {
    long dp[];
    long[][] nck;
    int[] log2;
    long mod = 1000000007;
    
    public int solve(int A) {
        dp = new long[A + 1];
        for(int i = 0; i <= A; i++) {
            dp[i] = -1;
        }
        
        nck = new long[A+1][A+1];
        for(int i=0;i<=A;i++)
            for(int j=0;j<=A;j++)
                nck[i][j] = -1;
                
        log2 = new int[A+1];
        int currLogAnswer = -1;
        int currPower2 = 1;
        for(int i=1;i<=A;i++)
        {
        if(currPower2==i)
            {
                currLogAnswer++;
                currPower2*=2;
            }
            log2[i] = currLogAnswer;
        }                
                
        return (int) solverec(A);
    }
    
    int getL(int A) {
        if (A == 1) {
            return 0;
        }
        int h = log(A, 2);
        int m = 1 << h;//(int) Math.pow(2, h);
        int p = A - (m - 1);
        int l;
        if (p >= m / 2) {
            l = m - 1;
        } else {
            l = m - 1 - (m / 2 - p);
        }
        return l;        
    }
    
    long solverec(int A) {
        if (A <= 1) {
            return 1;
        }
        if (dp[A] != -1) {
            return dp[A];
        }
        int l = getL(A);
        dp[A] = 
            ( 
                (rep(A - 1, l) 
                * solverec(l)) % mod
                * solverec(A - l - 1) 
            ) % mod;
        return dp[A];
    }
    
    long rep(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (k == 0) {
            return 1;
        }
        
        if(nck[n][k]!=-1L)
            return nck[n][k];
            
        nck[n][k] = (rep(n - 1, k - 1) + rep(n - 1, k)) % mod;
        return nck[n][k];
    }
    
    int log(int x, int base) {
        //return (int) (Math.log(x) / Math.log(base));
        return log2[x];
    }
}
