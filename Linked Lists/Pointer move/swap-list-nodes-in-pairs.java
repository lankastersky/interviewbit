/*
Swap List Nodes in pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
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
    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode prev = null;
        ListNode head = A;
        ListNode tail = A.next;
        ListNode root = A.next;
        while (tail != null) {
            ListNode next = tail.next;
            if (prev != null) {
                prev.next = tail;
            }
            head.next = next;
            tail.next = head;
            
            prev = head;
            head = next;
            if (next == null) {
                break;
            }
            tail = next.next;
            
            // System.out.println("p,h,t:" + prev.val + "," + head.val
            //   + "," + tail.val);
        }
        return root;
    }
}
