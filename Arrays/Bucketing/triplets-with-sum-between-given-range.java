/*
Triplets with Sum between given range

Given an array of real numbers greater than zero in form of strings.
Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . 
Return 1 for true or 0 for false.

Example:

Given [0.6, 0.7, 0.8, 1.2, 0.4] ,

You should return 1

as

0.6+0.7+0.4=1.7

1<1.7<2

Hence, the output is 1.

O(n) solution is expected.

Note: You can assume the numbers in strings don’t overflow the primitive data type
and there are no leading zeroes in numbers. Extra memory usage is allowed.

https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
*/

  public class Solution {
    public int solve(ArrayList<String> A) {
      int n = A.size();
      if (n < 3) {
        return 0;
      }
      ArrayList<Double> a = new ArrayList<>();
      for (String s: A) {
        double d = Double.valueOf(s);
        if (d >= 2) {
          continue;
        }
        a.add(d);
      }
      n = a.size();
      // Gives TLE
      // Collections.sort(a);
      // for (int i = 1; i < n - 1; i++) {
      //     int l = i - 1;
      //     int r = i + 1;
      //     while (true) {
      //         double sum = a.get(l) + a.get(i) + a.get(r);
      //         if (sum >= 2) {
      //             l--;
      //             if (l < 0) {
      //                 break;
      //             }
      //         }
      //         else if (sum <= 1) {
      //             r++;
      //             if (r == n) {
      //                 break;
      //             }
      //         }
      //         else {
      //             return 1;
      //         }
      //     }
      // }

      // Let A=(0,2/3), B=[2/3,1] and C=(1,2)
      //  we  need 3 largest values in range A,
      // 2 smallest in range B,
      // 2 smallest in range A
      // and the smallest in range C

      double amax1 = Integer.MIN_VALUE;
      double amax2 = Integer.MIN_VALUE;
      double amax3 = Integer.MIN_VALUE;
      double amin1 = Integer.MAX_VALUE;
      double amin2 = Integer.MAX_VALUE;
      double bmin1 = Integer.MAX_VALUE;
      double bmin2 = Integer.MAX_VALUE;
      double cmin = Integer.MAX_VALUE;

      for (double d: a) {
        if (d < 2d / 3) {
          if (amax1 < d) {
            amax3 = amax2;
            amax2 = amax1;
            amax1 = d;
          } else if (amax2 < d) {
            amax3 = amax2;
            amax2 = d;
          } else if (amax3 < d) {
            amax3 = d;
          }

          if (amin1 > d) {
            amin2 = amin1;
            amin1 = d;
          } else if (amin2 > d) {
            amin2 = d;
          }
        } else if (d <= 1) {
          if (bmin1 > d) {
            bmin2 = bmin1;
            bmin1 = d;
          } else if (bmin2 > d) {
            bmin2 = d;
          }
        } else if (cmin > d) {
          cmin = d;
        }
      }

      double sum;
      // 1.A, A, A
      sum = amax1 + amax2 + amax3;
      if (1 < sum && sum < 2) {
        return 1;
      }
      // 2.A, A, B
      sum = amax1 + amax2; // range of sum (0,4/3)
      // check if there is a value in B + sum > 1 && B + sum < 2
      for (double d: a) {
        if (2d / 3 <= d && d <= 1) {
          if (1 < d + sum && d + sum < 2) {
            return 1;
          }
        }
      }
      // check overflow

      // 3.A, A, C
      sum = amin1 + amin2 + cmin;
      if (1 < sum && sum < 2) {
        return 1;
      }

      // 4.A, B, B
      sum = bmin1 + bmin2; // range of sum [4/3,2]
      // check if there is a value in A + sum < 2
      for (double d: a) {
        if (d < 1) {
          if (d + sum < 2) {
            return 1;
          }
        }
      }

      // 5.A, B, C
      sum = amin1 + bmin1 + cmin;
      if (1 < sum && sum < 2) {
        return 1;
      }

      return 0;
    }
  }
