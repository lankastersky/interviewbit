/*
Remove Nth Node from List End

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.

https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
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
    public ListNode removeNthFromEnd(ListNode A, int n) {
        int l = getLength(A);
        if (n >= l) {
            return A.next;
        }
        // move to (l - n) pos
        ListNode h = A;
        for (int i = 0; i < l - n - 1; i++) {
            h = h.next;
        }
        h.next = h.next.next;
        return A;
    }
    
    int getLength(ListNode A) {
        int x = 0;
        while (A != null) {
            A = A.next;
            x++;
        }
        return x;
    }
}
