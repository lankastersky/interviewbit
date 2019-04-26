/*
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20

https://www.interviewbit.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode a = A;
        ListNode b = B;
        ListNode head = null;
        ListNode cur = null;
        while (a != null && b != null) {
            ListNode node = new ListNode(0);
            if (cur == null) {
                head = node;
            } else {
                cur.next = node;
            }
            cur = node;
            if (a.val < b.val) {
                node.val = a.val;
                a = a.next;
            } else {
                node.val = b.val;
                b = b.next;
            }
        }
        if (a != null) {
            if (cur == null) {
                cur = a;
                head = cur;
            } else {
                cur.next = a;
            }
        }
        if (b != null) {
            if (cur == null) {
                cur = b;
                head = cur;
            } else {
                cur.next = b;
            }
        }
        return head;
    }
}
