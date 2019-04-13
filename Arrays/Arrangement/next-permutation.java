/*
Next Permutation

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
20, 50, 113 → 20, 113, 50

Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

https://www.interviewbit.com/problems/next-permutation/
*/

public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        int n = a.size();
        if (n <= 1) {
            return;
        }
        for (int i = n - 1; i > 0; i--) {
            if (a.get(i - 1) < a.get(i)) {
                perm(a, i - 1);
                return;
            }
        }
        Collections.sort(a);
    }
    
    void perm(ArrayList<Integer> a, int k) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = k; i < a.size(); i++) {
            set.add(a.get(i));
        }
        int start = a.get(k);
        println("start: " + start);
        for (int i: set) {
            if (start < i) {
                start = i;
                break;
            }
        }
        set.remove(start);
        println("new start: " + start);
        a.set(k++, start);
        for (int i: set) {
            print(i + "");
            a.set(k++, i);
        }
        println("");
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }
    
    void println(String s) {
        //System.out.println(s);
    }
}
