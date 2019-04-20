/*
Compare Version Numbers

Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the 
second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

https://www.interviewbit.com/problems/compare-version-numbers/
*/

public class Solution {
    char DOT = '.';

    public int compareVersion(String A, String B) {
        int[] i = new int[1];
        int[] j = new int [1];
        
        // Doesn't work for version > Long.MAX_INT
        // A = trim(A);
        // println(A);
        // B = trim(B);
        // println(B);
        
        // while (true) {
        //     int a = getver(A, i);
        //     int b = getver(B, j);
            
        //     println(a + "," + b + ": " + i[0] + "," + j[0]);
            
        //     if (a == -1 && b == -1) {
        //         return 0;
        //     }
        //     if (a != -1 && b == -1) {
        //         return 1;
        //     }
        //     if (a == -1 && b != -1) {
        //         return -1;
        //     }
        //     if (a > b) {
        //         return 1;
        //     }
        //     if (a < b) {
        //         return -1;
        //     }
        // }
        
        int res = 0;
        while (true) {
            String a = getver(A, i);
            String b = getver(B, j);
            println(a + "," + b + ": " + i[0] + "," + j[0]);
            
            int size = Math.max(a.length(), b.length());
            a = align(a, size);
            b = align(b, size);
            
            if (a.isEmpty() && b.isEmpty()) {
                return 0;
            }
            
            res = a.compareTo(b);
            if (res != 0) {
                return res > 0 ? 1 : -1;
            }
        }
        //return res;
    }
    
    // String trim(String s) {
    //     int n = s.length();
    //     int[] ind = new int[1];
    //     for (int i = n - 1; i >= 0; i--) {
    //         if (s.charAt(i) == DOT) {
    //             ind[0] = i + 1;
    //             int a = getver(s, ind);
    //             if (a != 0) {
    //                 return s;
    //             }
    //             s = s.substring(0, i);
    //             i = s.length();
    //         }
    //     }
    //     return s;
    // }
    
    // int getver(String A, int[] ind) {
    //     int n = A.length();
    //     int i = ind[0];
    //     Stack<Integer> stack = new Stack<>();
    //     while (i < n && A.charAt(i) != DOT) {
    //         char c = A.charAt(i);
    //         int d = c - '0';
    //         stack.add(d);
    //         i++;
    //     }
    //     if (stack.isEmpty()) {
    //         return -1;
    //     }
    //     if (i < n) {
    //         i++; // skip DOT
    //     }
    //     int mul = 1;
    //     int a = 0;
    //     while (!stack.isEmpty()) {
    //         int d = stack.pop();
    //         a += d * mul;
    //         mul *= 10;
    //     }
    //     ind[0] = i;
    //     return a;
    // }
    
    // Returns a string between two dots or a dot and an edge
    String getver(String s, int[] ind) {
        int n = s.length();
        int i = ind[0];
        if (i >= n) {
            return "";
        }
        while (i < n && s.charAt(i) != DOT) {
            char c = s.charAt(i);
            i++;
        }
        String res = s.substring(ind[0], i);
        i++; // skip DOT
        ind[0] = i;
        return res;
    }
    
    // Adds leading zeros of total size='size'
    String align(String s, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - s.length(); i++) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    void println(String s) {
        //System.out.println(s);
    }
}
