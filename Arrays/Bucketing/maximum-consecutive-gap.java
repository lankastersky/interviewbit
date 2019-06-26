/*
Maximum Consecutive Gap

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

https://www.interviewbit.com/problems/maximum-consecutive-gap/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a: A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        if (min == max) {
            return 0;
        }
        int N = A.size();
        if (N < 2) {
            return 0;
        }
        double gap = ((double) max - min) / (N - 1);
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            b.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            int a = A.get(i);
            int number = (int) ( ((double) a - min) / gap );
            ArrayList<Integer> bucket = b.get(number);
            bucket.add(a);
        }
        max = 0;
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> bucket = b.get(i);
            if (bucket.isEmpty()) {
                continue;
            }
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int a: bucket) {
                min = Math.min(min, a);
                max = Math.max(max, a);                
            }
            bucket.clear();
            bucket.add(min);
            bucket.add(max);
            b2.add(bucket);
        }
        b = b2;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < b.size(); i++) {
            ArrayList<Integer> bucket = b.get(i);
            ArrayList<Integer> prev = i == 0 ? null : b.get(i - 1);
            if (prev != null) {
                max = Math.max(max, bucket.get(0) - prev.get(prev.size() - 1));
            }
        }
        return max;
    }
}
