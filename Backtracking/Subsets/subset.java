/*
Subset

Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]

https://www.interviewbit.com/problems/subset/
*/

public class Solution {
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if (A == null) {
            return null;
        }
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        x.add(new ArrayList<Integer>()); // empty one
        subset(A, 0, x);
        return x;
    }
    
    void subset(ArrayList<Integer> A, 
        int start, 
        ArrayList<ArrayList<Integer>> x) {
            
        if (start == A.size()) {
            return;
        }
        
        ArrayList<Integer> prev;
        if (!x.isEmpty()) {
            prev = x.get(x.size() - 1);
        } else {
            prev = new ArrayList<>();
        }
        for (int i = start; i < A.size(); i++) {
            ArrayList<Integer> a = new ArrayList(prev);
            a.add(A.get(i));
            x.add(a);
            subset(A, i + 1, x);
        }
    }
    
    // Gives TLE
    // public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
    //     if (A == null) {
    //         return null;
    //     }

    //     Set<Set<Integer>> x = new HashSet<>();
    //     //Collections.sort(A);
    //     Set<Integer> a = new HashSet<>(A);
        
    //     subset(a, x);

    //     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    //     for (Set<Integer> elem: x) {
    //         ArrayList<Integer> arr = new ArrayList<>();
    //         arr.addAll(elem);
    //         Collections.sort(arr);
    //         res.add(arr);
    //     }
    //     Collections.sort(res, (l, r) -> {
    //         int size = Math.min(l.size(), r.size());
    //         for (int i = 0; i < size; i++) {
    //             int c = Integer.compare(l.get(i), r.get(i));
    //             if (c != 0) {
    //                 return c;
    //             }
    //         }
    //         return Integer.compare(l.size(), r.size());
    //     });
    //     return res;
    // }
    
    // void subset(Set<Integer> A, Set<Set<Integer>> x) {
    //     x.add(A);
    //     if (A.isEmpty()) {
    //         return;
    //     }
    //     for (Integer elem: A) {
    //         Set<Integer> a = new HashSet<>(A);
    //         a.remove(elem);
    //         subset(a, x);
    //     }
    // }
}
