/*
Find Duplicate in Array

Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
https://www.interviewbit.com/problems/find-duplicate-in-array/
*/

public class Solution {
    int k = 10;
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int b[] = new int[n / k + 1];
        for (int i = 0; i < n; i++) {
            b[(a.get(i) - 1) / k]++;
        }
        int max = -1;
        if (n <= k) {
            max = 0;
        } else {
            for (int i = 0; i < n / k; i++) {
                //System.out.print(b[i] + " ");
                if (b[i] > k) {
                    max = i;
                    break;
                }
            }
        }
        if (max == -1) {
            if (b[n / k] < n % k) {
                max = n / k;
            }
        }
        if (max == -1) {
            return checkrem(a);
        }
        //System.out.println("\nbucket no:" + max);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if ((a.get(i) - 1) / k == max) {
                //System.out.println(" " + a.get(i));
                if (set.contains(a.get(i))) {
                    return a.get(i);
                }
                set.add(a.get(i));
            }
        }
        return - 1;
    }
    
    int checkrem(List<Integer> a) {
        int n = a.size();
        int rem = -1;
        for (int i = 0; i < k; i++) {
            int expected = n / k;
            if (i < n % k) {
                expected++;
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a.get(j) % k == i) {
                    count++;
                }
            }
            if (count > expected) {
                rem = i;
                break;
            }
        }
        if (rem == -1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a.get(i) % k == rem) {
                if (set.contains(a.get(i))) {
                    return a.get(i);
                }
                set.add(a.get(i));
            }
        }
        return -1;        
    }
}
