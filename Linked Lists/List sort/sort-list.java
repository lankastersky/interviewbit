/*
Sort List

Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5

https://www.interviewbit.com/problems/sort-list/
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode A) {
        ListNode l = null;
        ListNode lcur = null;
        ListNode r = null;
        ListNode rcur = null;
        int n = getLength(A);
        if (n < 2) {
            return A;
        }
        int i = 0;
        ListNode c = A;
        while (c != null) {
            if (i < n / 2) {
                if (l == null) {
                    l = c;
                } else {
                    lcur.next = c;
                }
                lcur = c;
                c = c.next;
                lcur.next = null;
            } else {
                if (r == null) {
                    r = c;
                } else {
                    rcur.next = c;
                }
                rcur = c;
                c = c.next;
                rcur.next = null;
            }
            i++;
        }
        l = sortList(l);
        r = sortList(r);
        return merge(l, r);
    }
    
    int getLength(ListNode A) {
        int x = 0;
        while (A != null) {
            A = A.next;
            x++;
        }
        return x;
    }
    
    ListNode merge(ListNode l, ListNode r) {
        ListNode list = null;
        ListNode head = null;
        while (l != null || r != null) {
            if ((l != null && r == null) || (l != null && r != null && l.val < r.val)) {
                if (head == null) {
                    head = l;
                } else {
                    list.next = l;
                }
                list = l;
                l = l.next; 
            } else {
                if (head == null) {
                    head = r;
                } else {
                    list.next = r;
                }
                list = r;                
                r = r.next;
            }
        }
        return head;
    }
}
