/*
Reverse Link List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously 
an easier version of this question. 

https://www.interviewbit.com/problems/reverse-link-list-ii/
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
    public ListNode reverseBetween(ListNode A, int B, int C) {
        if ( B == C) {
            return A;
        }
        // Find B-th node.
        ListNode cur = A;
        int i = 0;
        ListNode prev = null;
        while (i < B - 1 && cur != null) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        ListNode res = A;
        if (cur != null) {
            // Reverse the list from B to C.
            int K = C - B + 1;
            ListNode cur1 = cur;
            ListNode prev1 = null;
            ListNode next = null;
            i = 0;
            while (i < K) {
                i++;
                next = cur1.next; 
                cur1.next = prev1;
                prev1 = cur1;
                cur1 = next;
            }
            ListNode head = prev1;
            
            // Connect the tails.
            cur.next = next;
            //System.out.println("head, tail: " + head.val + ", " + cur.val);
            if (prev != null) {
                prev.next = head;
            } else {
                res = head; 
            }
        }
        return res;
    }
}
