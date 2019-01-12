/*
Points on the Straight Line

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Sample Input :

(1, 1)
(2, 2)
Sample Output :

2
You will be give 2 arrays X and Y. Each point is represented by (X[i], Y[i])

https://www.interviewbit.com/problems/points-on-the-straight-line/
*/

    public class Solution {
        public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
            if (a == null || b == null) {
                return 0;
            }
            if (a.size() != b.size()) {
                return 0;
            }
            if (a.size() <=2) {
                return a.size();
            }
            int n = a.size();
            //ArrayList<Set<Integer>> lines = new ArrayList<>();
            int x = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a.get(i) == a.get(j) && b.get(i) == b.get(j)) {
                        continue;
                    }
                    Set<Integer> points = new HashSet<>();
                    points.add(i);
                    points.add(j);
                    //lines.add(points);
                    for (int k = 0; k < n; k++) {
                        if (points.contains(k)) {
                            continue;
                        }
                        if (collinear(
                                a.get(i), b.get(i),
                                a.get(j), b.get(j),
                                a.get(k), b.get(k))) {

                            points.add(k);
                        }
                    }
                    if (x < points.size()) {
                        x = points.size();
                    }
                }
            }
            // int x = 0;
            // int ind = -1;
            // for (int i = 0; i < lines.size(); i++) {
            //     if (x < lines.get(i).size()) {
            //         x = lines.get(i).size();
            //         ind = i;
            //     }
            // }
            if (x == 0) {
                return a.size();
            }
            // for (int i: lines.get(ind)) {
            //     System.out.print("(" + a.get(i) + "," + b.get(i) + ") ");
            // }
            return x;
        }

        boolean collinear(long x1, long y1, long x2, long y2, long x3, long y3) {
             long l = (y1 - y2) * (x1 - x3);
             long r = (y1 - y3) * (x1 - x2);
             if (l != 0 && r != 0) {
                 return l == r;
             }
             if (y1 == y2 && y2 == y3) {
                 return true;
             }
             if (x1 == x2 && x2 == x3) {
                 return true;
             }
             return false;
    
            // return (y2 - y1) * x3 +(x2 - x1) * y3 + (x1 * y2 - x2 * y1) == 0;
    
//            if ((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2) &&
//                    (y3 - y2) * (x1 - x3) == (y2 - y3) * (x1 - x2)) {
//                return true;
//            }
//            return false;
        }
    }
