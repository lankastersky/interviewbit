/*
Rotate Matrix

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]

https://www.interviewbit.com/problems/rotate-matrix/
*/

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int d = 0;
        while (d < n / 2) {
            for (int i = d; i < n - d - 1; i++) {
                int lu = a.get(d).get(i);
                int ru = a.get(i).get(n - d - 1);
                int rb = a.get(n - d - 1).get(n - i - 1);
                int lb = a.get(n - i - 1).get(d);
                int t = lu;
                //System.out.println("|" + d + "," + i + ":" + lb);
                a.get(d).set(i, lb); // lu = lb;
                //System.out.println("<-" + (n - i - 1) + "," + d + ":" + rb);
                a.get(n - i - 1).set(d, rb); // lb = rb;
                //System.out.println("|" + (n - d - 1) + "," + (n - i - 1) + ":" + ru);
                a.get(n - d - 1).set(n - i - 1, ru); //rb = ru;
                //System.out.println("->" + i + "," + (n - d - 1) + ":" + t);
                a.get(i).set(n - d - 1, t); //ru = t;
            }
            d++;
        }
    }
}
