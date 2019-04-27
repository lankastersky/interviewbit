/*
2 Sum

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. 
Please note that your returned answers (both index1 and index2 ) are not zero-based. 
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature
will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2,
choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

https://www.interviewbit.com/problems/2-sum/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        SortedSet<Integer> set = new TreeSet<>(A);
        int n = A.size();
        int index1 = n;
        int index2 = n;
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            if (set.contains(K - a)) {
                for (int j = i + 1; j < A.size(); j++) {
                    int b = A.get(j);
                    if (b != K - a) {
                        continue;
                    }
                    if (index2 > j) {
                        index1 = i;
                        index2 = j;
                    } else if (index2 == j) {
                        if (index1 > i) {
                            index1 = i;
                            index2 = j;
                        }
                    }
                }

            }
        }
        if (index1 != n) {
            res.add(index1 + 1);
            res.add(index2 + 1);
        }
        return res;
    }
}
