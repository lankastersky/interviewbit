/*
Palindrome List

Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

https://www.interviewbit.com/problems/palindrome-list/
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
    public int lPalin(ListNode A) {
        int n = length(A);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int plength = n / 2;
        
        // Find the middle of the list.
        ListNode rhead = A;
        int i = 0;
        while (i++ < plength) {
            rhead = rhead.next;
        }
        //System.out.println("rh: " + rhead);
        
        // Reverse last half of the list.
        ListNode prev = null;
        ListNode current = rhead;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        rhead = prev;
        //System.out.println("rh rev: " + rhead);
        
        // Compare two halves.
        ListNode lhead = A;
        i = 0;
        while (i++ < plength) {
            if (lhead.val != rhead.val) {
                return 0;
            }
            lhead = lhead.next;
            rhead = rhead.next;
        }
        return 1;
    }
    
    int length(ListNode head) {
        int x = 0;
        while (head != null) {
            x++;
            head = head.next;
        }
        return x;
    }
}
