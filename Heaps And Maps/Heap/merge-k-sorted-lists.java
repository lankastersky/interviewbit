/*
Merge K Sorted Lists

Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

https://www.interviewbit.com/problems/merge-k-sorted-lists/
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
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> minheap = 
            new PriorityQueue<>(
                a.size(),
                (ListNode left, ListNode right) -> Integer.compare(left.val, right.val));
        minheap.addAll(a);
        ListNode head = null;
        ListNode cur = null;
        while (!minheap.isEmpty()) {
            ListNode node = minheap.poll();
            if (head == null) {
                head = node;
            } else {
                cur.next = node;
            }
            cur = node;
            if (node.next != null) {
                minheap.add(node.next);
            }
        }
        return head;
        

        // Non-optimal; doesn't uses the fact that lists are already sorted
        // PriorityQueue<Integer> minheap = new PriorityQueue<>();
        // for (ListNode node: a) {
        //     while (node != null) {
        //         minheap.add(node.val);
        //         node = node.next;
        //     }
        // }
        
        // ListNode head = null;
        // ListNode cur = null;
        // while (!minheap.isEmpty()) {
        //     ListNode node = new ListNode(minheap.poll());
        //     if (head == null) {
        //         head = node;
        //     } else {
        //         cur.next = node;
        //     }
        //     cur = node;
        // }
        // return head;
    }
}
