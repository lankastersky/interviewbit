/*
Allocate Books

N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.

NOTE: Return -1 if a valid assignment is not possible

Input:

List of Books
M number of students
Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113. 

https://www.interviewbit.com/problems/allocate-books/
*/

// Based on https://www.topcoder.com/community/competitive-programming/tutorials/binary-search/

public class Solution {
    public int books(ArrayList<Integer> p, int m) {
        int n = p.size();
        if (n < m) {
            return -1;
        }
        int low = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, p.get(i));
        }
        int high = low * n;
        //int ans = 0;
        while (low < high) {
            int ans = (low + high) / 2;
            int acc = 0;
            int workers = 1;
            for (int i = 0; i < n; i++) {
                if (acc + p.get(i) > ans) {
                    workers++;
                    if (workers > m) {
                        break;
                    }
                    acc = p.get(i);
                    continue;
                }
                acc += p.get(i);
            }
            //System.out.println("l,h,w:" + low + "," + high + "," + workers);
            if (workers > m) {
                low = ans + 1;
            } else {
                high = ans;
            }
        }
        return (low + high) / 2;
    }
}
