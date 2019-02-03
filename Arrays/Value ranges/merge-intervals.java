/*
Merge Intervals

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

https://www.interviewbit.com/problems/merge-intervals/
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
    public ArrayList<Interval> insert(
        ArrayList<Interval> ins, Interval in) {
        
        if (ins.isEmpty()) {
            ins.add(in);
            return ins;
        }
        if (less(in, ins.get(0))) {
            ins.add(0, in);
            return ins;
        }

        int n = ins.size();
        boolean inserted = false;
        int i = 0;
        for (; i < n; i++) {
            Interval cur = ins.get(i);
            if (less(cur, in)) {
                continue;
            }
            if (laps(cur, in)) {
                in = merge(cur, in);
                ins.set(i, in);
                print("0", ins);
            } else {
                ins.add(i, in);
                print("1", ins);
            }
            inserted = true;
            break;
        }
        print("2", ins);
        if (inserted) {
            for (; i < ins.size() - 1; i++) {
                Interval cur = ins.get(i + 1);
                if (laps(in, cur)) {
                    in = merge(in, cur);
                    ins.remove(i);
                    ins.set(i, in);
                    i--;
                } else {
                    break;
                }
            }
        } else {
            ins.add(in);
        }
        return ins;
    }
    
    boolean less(Interval l, Interval r) {
        return l.end < r.start;
    }
    
    boolean laps(Interval l, Interval r) {
        return (l.end >= r.start) && (l.start <= r.end);
    }

    Interval merge(Interval l, Interval r) {
        return new Interval(
            Math.min(l.start, r.start),
            Math.max(l.end, r.end));
    }
    
    void print(String msg, ArrayList<Interval> ins) {
        // System.out.print(msg + ":");
        // for (Interval in: ins) {
        //     System.out.print(in.start + "," + in.end + " ");
        // }
        // System.out.println();
    }    
}
