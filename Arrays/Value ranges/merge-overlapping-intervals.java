/*
Merge Overlapping Intervals

Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.

https://www.interviewbit.com/problems/merge-overlapping-intervals/
*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        sort(intervals);
        
        // for (int j = 0; j < intervals.size(); j++) {
        //     System.out.print("(" + intervals.get(j).start + ", " + intervals.get(j).end + ") ");
        // }
        // System.out.println();
        
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval l = intervals.get(i);
            Interval r = intervals.get(i + 1);
            while (l.end >= r.start) {
                intervals.remove(l);
                intervals.remove(r);
                int s = Math.min(l.start, r.start);
                int e = Math.max(l.end, r.end);
                l = new Interval(s, e);
                intervals.add(i, l);
                if (i == intervals.size() - 1) {
                    break;
                }
                r = intervals.get(i + 1);
                
                // for (int j = 0; j < intervals.size(); j++) {
                //     System.out.print("(" + intervals.get(j).start + ", " + intervals.get(j).end + ") ");
                // }
                // System.out.print(" l: (" + l.start + ", " + l.end + ") ");
                // System.out.print(" r: (" + r.start + ", " + r.end + ") ");
                // System.out.println();                
            }
            i++;
        }
        return intervals;
    }
    
    // void sort(ArrayList<Interval> intervals) {
    //     for (int i = 0; i < intervals.size(); i++) {
    //         int min = i;
    //         for (int j = i + 1; j < intervals.size(); j++) {
    //             if (intervals.get(min).start > intervals.get(j).start) {
    //                 min = j;
    //             }
    //         }
    //         swap (intervals, i, min);
    //     }
    // }
    
    void sort(ArrayList<Interval> A) {
        quickSort(A, 0, A.size() - 1);
    }
    
    void quickSort(ArrayList<Interval> A, int l, int h) {
        if (l >= h) {
            return;
        }
        int p = partition(A, l, h);
        // for (int i = 0; i < A.size(); i++) {
        //     System.out.print(A.get(i) + " ");
        // }
        // System.out.println();
        quickSort(A, l, p);
        quickSort(A, p + 1, h);
    }
    
    int partition(ArrayList<Interval> A, int l, int h) {
        int m = (h + l) / 2; 
        Interval pivot = A.get(m);
        //System.out.println("l:" + l + ",h:" + h + ",m:" + m);
        int i = l - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (i < A.size() && A.get(i).start < pivot.start);
            
            do {
                j--;
            } while (j >= 0 && pivot.start < A.get(j).start);
            
            if (i >= j) {
                return j;
            }
            swap(A, i, j);
            // System.out.print("  i:" + i + ",j:" + j + " ");
            // for (int k = l; k <= h; k++) {
            //     System.out.print(A.get(k) + " ");
            // }
            // System.out.println();
        }
    }
    
    void swap(ArrayList<Interval> A, int i, int j) {
        if (i == j) {
            return;
        }
        Interval t = A.get(i);
        A.set(i, A.get(j));
        A.set(j, t);
    }
}
