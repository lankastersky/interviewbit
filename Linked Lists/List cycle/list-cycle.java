/*
List Cycle

NetApp
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

https://www.interviewbit.com/problems/list-cycle/
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
    public ListNode detectCycle(ListNode a) {
        ListNode f = a;
        ListNode s = a;
        int fs = 0;
        int ss = 0;
        int meet = 0;
        int meet2 = 0;
        int cycleLength = 0;
        while (f != null && s != null) {
            //System.out.println("f,s: " + f.val + ", " + s.val);
            fs++;
            f = f.next;
            s = s.next;
            if (s != null) {
                s = s.next;
            } else {
                break;
            }
            if (f == s) {
                if (meet == 0) {
                    meet = fs;
                } else {
                    meet2 = fs;
                    cycleLength = meet2 - meet;
                    //System.out.println("meet,meet2: " + meet + ", " + meet2);
                    break;
                }
            }
        }
        if (meet == 0) {
            return null;
        }
        
        f = a;
        fs = 0;
        while (fs < cycleLength) {
            f = f.next;
            fs++;
        }
        s = a;
        ss = 0;
        while (f != s && ss <= meet) {
            //System.out.println("f, s: " + f.val + ", " + s.val);
            f = f.next;
            s = s.next;
            ss++;
        }
        return f;
    }
}
