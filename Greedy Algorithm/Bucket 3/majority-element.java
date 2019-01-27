/*
Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 

https://www.interviewbit.com/problems/majority-element/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        Collections.sort(A);
        int count = 1;
        int max = 1;
        int el = A.get(0);
        int ind = 0;
        for (int i = 1; i < A.size(); i++) {
            //System.out.println("count, elem: " + count + "," + A.get(i - 1));
            if (A.get(i - 1).equals(A.get(i))) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                    el = A.get(i - 1);
                    ind = i - 1;
                    //System.out.println("ind, max: " + ind + "," + max);
                    if (max > Math.floor(A.size() / 2)) {
                        break;
                    }
                }
                count = 1;
            }
        }
        if (max < count) {
            max = count;
            el = A.get(A.size() - 1);
            ind = A.size() - 1;
            //System.out.println("ind, max: " + ind + "," + max);
        }

        // for (int i = 0; i < A.size(); i++) {
        //     System.out.print(A.get(i) + " ");
        // }

        return el;
    }
}
