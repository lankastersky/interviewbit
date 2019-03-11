/*
Equal

Given an array A of integers, find the index of values that satisfy A + B = C + D, 
where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

https://www.interviewbit.com/problems/equal/
*/

public class Solution {
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n < 4) {
            return res;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Comparator<ArrayList<Integer>> comp = 
            (ArrayList<Integer> a, ArrayList<Integer> b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) == b.get(i)) {
                    continue;
                }
                return Integer.compare(a.get(i), b.get(i));
            }
            return 0;
        };
        SortedSet<ArrayList<Integer>> set = new TreeSet<>(comp);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                if (map.containsKey(sum)) {
                    ArrayList<Integer> list = map.get(sum);
                    if (list.get(0) >= i) {
                        continue;
                    }
                    if (list.get(1) == i || list.get(1) == j) {
                        continue;
                    }
                    res = new ArrayList<Integer>();
                    res.add(list.get(0));
                    res.add(list.get(1));
                    res.add(i);
                    res.add(j);
                    //return res;
                    set.add(res);
                }
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(sum, list);
            }
        }
        if (set.isEmpty()) {
            return new ArrayList<Integer>();
        }
        res = set.first();
        return res;
    }
}
