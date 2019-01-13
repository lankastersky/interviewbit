/*
Magician and Chocolates
Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7

https://www.interviewbit.com/problems/magician-and-chocolates/
*/

public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> queue = 
          new PriorityQueue<Integer>(B.size(), Collections.reverseOrder());
        for (int i: B) {
            queue.add(i);
        }
        long x = 0;
        long mod = 1000000007;//(long) Math.pow(10, 9) + 7;
        for (int i = 0; i < A; i++) {
            int cur = queue.poll();
            if (cur == 0) {
                break;
            }
            x = (x + cur) % mod;
            //System.out.println("cur, x:" + cur + "," + x);
            queue.add(cur / 2);
        }
        return (int) (x % mod);
    }
}
