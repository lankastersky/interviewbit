/*
Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

https://www.interviewbit.com/problems/rotate-list/
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
    public ListNode rotateRight(ListNode A, int K) {
        if (K == 0) {
            return A;
        }
        if (A == null) {
            return A;
        }
        ListNode n1 = A;
        ListNode n2 = A;
        int k = 0;
        while (k < K) {
            n2 = n2.next;
            if (n2 == null) {
                n2 = A;
            }
            k++;
        }
        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        if (n1.next == null) {
            return A;
        }
        ListNode head = n1.next;
        n1.next = null;
        n2.next = A;
        return head;
    }
}
