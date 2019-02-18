/*
Median of Array

There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5

https://www.interviewbit.com/problems/median-of-array/
*/

public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(
        final List<Integer> A, final List<Integer> B) {

        List<Integer> a = A;
        List<Integer> b = B;
        if (a.size() > b.size()) {
            List<Integer> temp = a;
            a = b;
            b = temp;
        }
        // Assume m <= n
        int m = a.size();
        int n = b.size();
        
        int imin = 0;
        int imax = m;
        double res = 0;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            // i + j = (m - i) + (n - j) + 1
            int j = (m + n + 1) / 2 - i;
            //System.out.println("imin,imax, i,j:" + imin + "," + imax
            //    + ", " + i + "," + j);
            if (j != 0 && i != m && b.get(j - 1) > a.get(i)) {
                imin = i + 1;
            } else if (i != 0 && j != n && a.get(i - 1) > b.get(j)) {
                imax = i - 1;
            } else {
                // This part is tricky!
                int med1 = 0, med2 = 0;
                if(i==0)
                    med1=b.get(j-1);
                else if(j==0)
                    med1 = a.get(i-1);
                else
                    med1 = Math.max(a.get(i-1),b.get(j-1));
                
                if((m+n)%2 == 1)
                    return (double)med1;
                
                if(i==m)
                    med2 = b.get(j);
                else if(j==n)
                    med2 = a.get(i);
                else
                    med2 = Math.min(a.get(i),b.get(j));
                
                return (double)(med1+med2)/2.0;                
            }
        }
        return res;

    }
}
