/*
Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

https://www.interviewbit.com/problems/partition-list/
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
    public ListNode partition(ListNode A, int B) {
        ListNode less = null;
        ListNode more = null;
        ListNode lessHead = null;
        ListNode moreHead = null;
        ListNode head = A;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            if (head.val < B) {
                if (less != null) {
                    less.next = node;
                } else {
                    lessHead = node;
                }
                less = node;
            } else {
                if (more != null) {
                    more.next = node;
                } else {
                    moreHead = node;
                }
                more = node;
            }
            head = head.next;
        }
        if (less != null) {
            less.next = moreHead;
            return lessHead;
        }
        return A;
    }
}
