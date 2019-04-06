/*
Distribute Candy

There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Sample Input :

Ratings : [1 2]
Sample Output :

3
The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. 
So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.

https://www.interviewbit.com/problems/distribute-candy/
*/

public class Solution {
    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        if (n <= 1) {
            return n;
        }
        int[] left = new int[n];  // store ups
        int[] right = new int[n]; // store downs

        for (int i = 0; i < n - 1; i++) {
            if (A.get(i) < A.get(i + 1)) {
                left[i + 1] = left[i] + 1;
            // } else if (A.get(i) == A.get(i + 1)) {
            //     left[i + 1] = left[i];
            // } else {
            //     left[i + 1] = 0;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (A.get(i - 1) > A.get(i)) {
                right[i - 1] = right[i] + 1;
            // } else if (A.get(i - 1) == A.get(i)) {
            //     right[i - 1] = right[i];
            // } else {
            //     left[i - 1] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            print(left[i] + "");
        }
        println("");
        for (int i = 0; i < n; i++) {
            print(right[i] + "");
        }
        println("");
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(left[i], right[i]);
            res += temp;
            print(temp + "");
        }
        println("");
        return res + n;
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
