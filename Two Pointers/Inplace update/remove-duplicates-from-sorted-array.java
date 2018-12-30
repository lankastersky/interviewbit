/*
Remove duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 

https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
*/

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null || a.isEmpty()) {
            return 0;
        }
        if (a.size() == 1) {
            return 1;
        }
        ListIterator<Integer> i = a.listIterator();
        int f, s;
        if (i.hasNext()) {
            f = i.next();
        } else {
            return 0;
        }
        // Mark every duplicate as null.
        while (i.hasNext()) {
            s = i.next();
            while (f == s) {
                //i.remove();
                i.set(null);
                if (i.hasNext()) {
                    s = i.next();
                } else {
                    break;
                }
            }
            f = s;
        }
        int c = -1;
        for (int k = 0; k < a.size(); k++) {
            if (a.get(k) == null && c == -1) {
                c = k;
                continue;
            }
            if (c != - 1) {
                if (a.get(k) != null) {
                    a.set(c, a.get(k));
                    c++;
                }
            }
        }
        int res = c == -1 ? a.size() : c;
        return res;
        
        // for (int k = 0; k < a.size(); k++) {
        //     System.out.print(a.get(k) + " ");
        // }
        // System.out.println("-");


        // v3. Move every null at the end of the array.
        // Gives TLE!
        // for (int k = 0; k < a.size(); k++) {
        //     if (a.get(k) == null) {
        //         for (int l = k + 1; l < a.size(); l++) {
        //             if (a.get(l) != null) {
        //                 swap(a, k, l);
        //                 break;
        //             }
        //         }
        //     }
        // }
        // // Calculate the length of the array with non-null elements.
        // for (int k = a.size() - 1; k >= 0; k--) {
        //     if (a.get(k) != null) {
        //         return k + 1;
        //     } 
        // }
        
        
        // v2. Swapping changes the order of elements and is not accepted
        // f = 0;
        // s = a.size() - 1;
        // while (f < s) {
        //     if (a.get(f) == null) {
        //         while (a.get(s) == null && f < s) {
        //             s--;
        //         }
        //         if (f == s) {
        //             break;
        //         }
        //         swap(a, f, s);
        //         s--;
        //     }
        //     f++;
        // }
        
        
        // v1. Gives TLE
        // int f, s;
        // if (i.hasNext()) {
        //     f = i.next();
        // } else {
        //     return 0;
        // }
        // while (i.hasNext()) {
        //     s = i.next();
        //     while (f == s) {
        //         i.remove();
        //         if (i.hasNext()) {
        //             s = i.next();
        //         } else {
        //             break;
        //         }
        //     }
        //     f = s;
        // }
        // if (a.get(f) != null) {
        //     f++;
        // }
        //return f;
    }
    
    // void swap(ArrayList<Integer> a, int f, int s) {
    //     //System.out.println("swap " + f + " " + s);
    //     Integer t = a.get(f);
    //     a.set(f, a.get(s));
    //     a.set(s, t);
    // }
}
