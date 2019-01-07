/*
Permutations

Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]
 NOTE
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 

https://www.interviewbit.com/problems/permutations/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return new ArrayList<>();
        }
        Set<Integer> a = new TreeSet(A);
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        perm(a, x, new ArrayList<>());
        return x;
    }
    
    void perm(Set<Integer> A, 
      ArrayList<ArrayList<Integer>> x, 
      ArrayList<Integer> current) {
      
      if (A.isEmpty()) {
          x.add(new ArrayList<>(current));
          return;
      }
      
      Set<Integer> a = new TreeSet<>(A);
      for (int i: A) {
          current.add(i);
          a.remove(i);
          perm(a, x, current);
          a.add(i);
          current.remove(current.size() - 1);
      }
   }
}
