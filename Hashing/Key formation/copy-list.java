/*
Copy List

A linked list is given such that each node contains an additional random pointer which could point to any node in the list 
or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, 
but a copy of them. 
The pointers in the returned list should not link to any node in the original input list.

https://www.interviewbit.com/problems/copy-list/
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // Make a copy of the list
        RandomListNode cur = head;
        RandomListNode prev = null;
        RandomListNode copyhead = null;
        while (cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            map.put(cur, copy);
            if (prev != null) {
                prev.next = copy;
            }
            if (copyhead == null) {
                copyhead = copy;
            }
            cur = cur.next;
            prev = copy;
        }
        
        // Make a copy of random nodes
        cur = head;
        RandomListNode copycur = copyhead;
        prev = null;
        while (cur != null) {
            RandomListNode random = cur.random;
            if (random != null) {
                RandomListNode randomcopy = map.get(random);
                copycur.random = randomcopy;
            }
            cur = cur.next;
            copycur = copycur.next;
        }
        return copyhead;
    }
}
