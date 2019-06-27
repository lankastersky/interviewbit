/*
N/3 Repeat Number

You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time
and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 

https://www.interviewbit.com/problems/n3-repeat-number/
*/

public class Solution {
    // Based on radix sort
    public int repeatedNumber(final List<Integer> a) {
        int N = a.size();
        if (a.isEmpty()) {
            return 0;
        }
        int size = 10;
        int buckets[] = new int[size];
        int buckets2[] = new int[size];
        int result = 0;
        long rem = 10;
        while (rem < (long) Integer.MAX_VALUE) {
            int d = -1;
            for (int i = 0; i < size; i++) {
                buckets[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                int el = a.get(i);
                int num = el % (int) rem;
                num /= ((int) rem / 10);
                buckets[num]++;
                if (buckets[num] > N / 3) {
                    d = num;
                    break;
                }
            }
            if (d == -1) {
                return -1;
            }
            result = result + d * ((int) rem / 10);
            rem *= 10;
            println(result + "");
        }
        int check = 0;
        for (int i: a) {
            if (result == i) {
                check++;
            }
        }
        if (check <= N / 3) {
            return -1;
        }
        return result;
    }
    void println(String s) {
        //System.out.println(s);
    }
}
