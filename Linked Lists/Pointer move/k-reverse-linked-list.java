/*
K reverse linked list

Problem Setter: mihai.gheorghe Problem Tester: yashpal1995
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.

https://www.interviewbit.com/problems/k-reverse-linked-list/
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
    public ListNode reverseList(ListNode A, int B) {
        if (B <= 1) {
            return A;
        }
        if (A == null) {
            return null;
        }
        int n = length(A);
        int nlists = n / B;
        ListNode head = A;
        ListNode prevLast = null; // the end of the previous list
        ListNode nextHead = null; // the head of the next list
        for (int i = 0; i < nlists; i++) {
            
            // Reverse the list of length B.
            ListNode prev = null;
            ListNode cur;
            if (prevLast != null) {
                cur = prevLast.next;
            } else {
                cur = A;
            }
            ListNode last = cur;
            ListNode next;
            int j = 0;
            while (j < B) {
                j++;
                if (j == B) {
                    nextHead = cur.next;
                } 
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = prev;
            
            // Connect the previous list with reversed list.
            if (prevLast != null) {
                prevLast.next = head;
            } else {
                A = head;
            }
            // Connect the reversed list with the next list.
            last.next = nextHead;
            
            prevLast = last; 
        }
        return A;
    }
    
    int length(ListNode head) {
        int x = 0;
        while (head != null) {
            head = head.next;
            x++;
        }
        return x;
    }
}
