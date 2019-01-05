/*
Reverse Link List Recursion

Reverse a linked list using recursion.

Example :
Given 1->2->3->4->5->NULL,

return 5->4->3->2->1->NULL.

https://www.interviewbit.com/problems/reverse-link-list-recursion/
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
    public ListNode reverseList(ListNode A) {
        if (A.next == null) {
            return A;
        }
        ListNode node = reverseList(A.next);
        ListNode q = A.next;
        q.next = A;
        A.next = null;
        return node;
    }
}
