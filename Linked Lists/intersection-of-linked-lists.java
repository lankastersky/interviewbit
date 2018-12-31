/*
Intersection of Linked Lists
Asked in:  
Amazon
Microsoft
NetApp
Apache Design
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

https://www.interviewbit.com/problems/intersection-of-linked-lists/
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
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int A = length(a);
        int B = length(b);
        if (A < B) {
            ListNode t = a;
            a = b;
            b = t;
        }
        // System.out.println("2 a,b: " + a.val + ", " + b.val);
        for (int d = 0; d < Math.abs(A - B); d++) {
            a = a.next;
        }
        // System.out.println("3 a,b: " + a.val + ", " + b.val);
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
    
    int length(ListNode a) {
        int x = 0;
        while (a != null) {
            x++;
            a = a.next;
        }
        return x;
    }
}
