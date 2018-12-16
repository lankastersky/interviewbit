/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]

https://www.interviewbit.com/problems/spiral-order-matrix-i/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int t = 0;
        int b = A.size() - 1;
        int l = 0;
        int r = A.get(0).size() - 1;
        int d = 0; // 0 ->, 1 v, 2 <-, 3 T
        while (t <= b && l <= r) {
          if (d == 0) { // right
            for (int i = l; i <= r; i++) {
                result.add(A.get(t).get(i));
            }
            t += 1;
            d = 1;              
          } else if (d == 1) { // down
            for (int i = t; i <= b; i++) {
                result.add(A.get(i).get(r));
            }
            r -= 1;
            d = 2;
          } else if (d == 2) { // left
            for (int i = r; i >= l; i--) {
                result.add(A.get(b).get(i));
            }
            b -= 1;
            d = 3;  
          } else if (d == 3) { // top
            for (int i = b; i >= t; i--) {
                result.add(A.get(i).get(l));
            }
            l += 1;
            d = 0;
          }
        }
        return result;
    }
}
