/*
Reorder List

Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

https://www.interviewbit.com/problems/reorder-list/
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
    int n;
    int count;
    
    public ListNode reorderList(ListNode A) {
        n = listSize(A);
        if (n <= 2) {
            return A;
        } 
        count = 1;
        //reorder(A);
        
        Stack<ListNode> stack = new Stack<>();
        
        ListNode tail = null;
        ListNode head = A;
        while (true) {
            if (n % 2 == 1 && count == n / 2 + 1) {
                tail = head;
                break;
            } else if (n % 2 == 0 && count == n / 2) {
                tail = head.next;
                break;
            }
            stack.push(head);
            head = head.next;
            count++;
        }
        
        while (!stack.isEmpty()) {
            head = stack.pop();
            ListNode temp = tail.next;
            tail.next = tail.next.next;
            temp.next = head.next;
            head.next = temp;
        }
        
        return A;
    }
    
    int listSize(ListNode A) {
        int res = 0;
        while (A != null) {
            A = A.next;
            res++;
        }
        return res;
    }
    
    // Gives Stack Overflow.
    // Returns tail of ordered list.
    // ListNode reorder(ListNode head) {
    //     if (n % 2 == 1 && count == n / 2 + 1) {
    //         //System.out.println("middle:" + head.val);
    //         return head;
    //     } else if (n % 2 == 0 && count == n / 2) {
    //         return head.next;
    //     }
    //     count++;
    //     ListNode tail = reorder(head.next);
    //     ListNode temp = tail.next;
    //     tail.next = tail.next.next;
    //     temp.next = head.next;
    //     head.next = temp;
    //     return tail;
    // }
}
