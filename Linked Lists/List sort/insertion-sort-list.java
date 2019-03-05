/*
Insertion Sort List

Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3

https://www.interviewbit.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode A) {
        if (A == null) {
            return A;
        }
        ListNode B = null;
        ListNode a = A;
        while (a != null) {
            int x = a.val;
            ListNode prev = null;
            ListNode b = B;
            
            while (b != null && b.val < x) {
                prev = b;
                b = b.next;
            }
            if (prev == null) { // head
                ListNode head = new ListNode(x);
                head.next = B;
                B = head;
            } else if (b == null) { // tail
                prev.next = new ListNode(x);
            } else { // insert between prev and b
                ListNode cur = new ListNode(x);
                cur.next = b;
                prev.next = cur;
            }
            a = a.next;
        }
        return B;
    }
}
