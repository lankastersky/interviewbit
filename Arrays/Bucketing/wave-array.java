/*
Wave Array

Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]

https://www.interviewbit.com/problems/wave-array/
*/

public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        ArrayList<Integer> r = sort(A);
        // for (int i = 0; i < r.size(); i++) {
        //     System.out.print(r.get(i) + " ");
        // }
        // System.out.println();
        for (int i = 0; i < r.size() - 1; i += 2) {
            swap(r, i, i + 1);
        }
        // for (int i = 0; i < r.size(); i++) {
        //     System.out.print(r.get(i) + " ");
        // }
        return r;
    }
    
    ArrayList<Integer> sort(ArrayList<Integer> A) {
        quickSort(A, 0, A.size() - 1);
        return A;
    }
    
    void quickSort(ArrayList<Integer> A, int l, int h) {
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
    
    int partition(ArrayList<Integer> A, int l, int h) {
        int m = (h + l) / 2; 
        int pivot = A.get(m);
        //System.out.println("l:" + l + ",h:" + h + ",m:" + m);
        int i = l - 1;
        int j = h + 1;
        while (true) {
            do {
                i++;
            } while (i < A.size() && A.get(i) < pivot);
            
            do {
                j--;
            } while (j >= 0 && pivot < A.get(j));
            
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
    
    void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
