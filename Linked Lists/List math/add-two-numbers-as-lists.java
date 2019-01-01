/*
Add Two Numbers as Lists

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

https://www.interviewbit.com/problems/add-two-numbers-as-lists/
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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode a = A;
        ListNode b = B;
        int d = 0;
        ListNode cur = null;
        ListNode head = null;
        while (a != null && b != null) {
            int val = a.val + b.val + d;
            d = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);
            if (cur != null) {
                cur.next = node;
            } else {
                head = node;
            }
            cur = node;
            a = a.next;
            b = b.next;
        }
        ListNode c = a != null ? a : b;
        while (c != null) {
            int val = c.val + d;
            d = val / 10;
            val = val % 10;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;
            c = c.next;
        }
        if (d != 0) {
            ListNode node = new ListNode(d);
            cur.next = node;
        }
        return head;
    }
    
    // Doesn't work on big numbers.
    // public ListNode addTwoNumbers(ListNode A, ListNode B) {
    //     if (A == null || B == null) {
    //         return null;
    //     }
    //     long a = makeNumber(A);
    //     long b = makeNumber(B);
    //     long c = a + b;
    //     ListNode cur = null;
    //     ListNode head = null;
    //     while (c != 0) {
    //         int val = (int) (c % 10L);
    //         c = c / 10;
    //         ListNode node = new ListNode(val);
    //         if (cur != null) {
    //             cur.next = node;        
    //         } else {
    //             head = node;
    //         }
    //         cur = node;
    //     }
    //     return head;        
    // }
    
    // long makeNumber(ListNode head) {
    //     long x = 0;
    //     long i = 1;
    //     while (head != null) {
    //         x += head.val * i;
    //         i *= 10;
    //         head = head.next;
    //     }
    //     return x;
    // }
}
