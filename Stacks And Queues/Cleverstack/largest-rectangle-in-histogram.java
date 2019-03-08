/*
Largest Rectangle in Histogram

Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

For example,
Given height = [2,1,5,6,2,3],
return 10.

https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
*/

//    A = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3}));
//    assertEquals(s.largestRectangleArea(A), 4);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {3, 2, 1}));
//    assertEquals(s.largestRectangleArea(A), 4);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {3, 2, 1, 2, 3}));
//    assertEquals(s.largestRectangleArea(A), 5);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 2, 1}));
//    assertEquals(s.largestRectangleArea(A), 6);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {3, 2, 1, 2, 3, 2, 1}));
//    assertEquals(s.largestRectangleArea(A), 7);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 2, 1, 2, 3, 2, 1}));
//    assertEquals(s.largestRectangleArea(A), 9);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {6, 2, 5, 4, 5, 1, 6}));
//    assertEquals(s.largestRectangleArea(A), 12);
//
//    A = new ArrayList<>(Arrays.asList(new Integer[] {90, 58, 69, 70, 82, 100, 13, 57, 47, 18}));
//    assertEquals(s.largestRectangleArea(A), 348);

  public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
      int n = A.size();
      if (n == 0) {
        return 0;
      }
      int res = 0;

      Stack<Integer> stack = new Stack<>();
      // O(n^2); Gives TLE
      // for (int i = 0; i < n; i++) {
      //     int layer = A.get(i);
      //     int tmp = 0;
      //     for (int j = 0; j < n; j++) {
      //         if (A.get(j) >= layer) {
      //             tmp += layer;
      //             res = Math.max(res, tmp);
      //         } else {
      //             tmp = 0;
      //         }
      //     }
      //     //System.out.println("i,res:" + i + "," + res);
      // }


      for (int i = 0; i < n; i++) {
        int el = A.get(i);
        if (stack.isEmpty() || A.get(stack.peek()) <= el) {
          stack.push(i);
          continue;
        }
        int r = i;
        while (!stack.isEmpty() && A.get(stack.peek()) >= el) {
          int h = A.get(stack.pop());
          int l = -1;
          if (!stack.isEmpty()) {
            l = stack.peek();
          }
          int rec = (r - l - 1) * h;
          res = Math.max(res, rec);
          //System.out.println(i + ":" + res);
        }
        stack.push(i);
      }
      if (stack.isEmpty()) {
        return res;
      }
      //System.out.println("-");
      int r = stack.peek();

      while (!stack.isEmpty()) {
        int i = stack.pop();
        int h = A.get(i);
        int l = -1;
        if (!stack.isEmpty()) {
          l = stack.peek();
        }
        int rec = (r - l) * h;
        res = Math.max(res, rec);
        //System.out.println(i + ":" + res);
      }
      return res;
    }

  }
