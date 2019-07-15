/*
Smallest Multiple With 0 and 1

You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. 
Since this multiple could be large, return it in form of a string.

Note:

Returned string should not contain leading zeroes.
For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.

https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
*/

public class Solution {
    class Node {
        int val;
        int digit;
        Node parent;
        Node(int v, int d, Node p) {
            val = v;
            digit = d;
            parent = p;
        }
    }
    
    // Based on 
    // https://stackoverflow.com/questions/16458026/how-to-find-the-smallest-number-with-just-0-and-1-which-is-divided-by-a-given-nu#
    // All possible digits that can be constructed using the digits 0 and 1 can be traversed
    // as a tree, where at each level, appending a 0 is one branch and appending a 1 is another
    //
    // If we perform BFS on this tree, the first number we see which is an exact multiple of the input
    // number will be the result
    // The 2 paths we take at each level when the current number is num:
    //      (num * 10)
    //      (num * 10) + 1
    // The operation we perform above (i.e. multiplications and additions) still work when using modulo
    // Since we use the given number itself as the modulo, when we see a modulo result of 0, it will imply
    // we've hit the result during BFS
    //
    // To reconstruct the number, we need to store the parents when adding the node in the queue (similar to
    // using BFS for computing shortest path)
    //
    // We will also need to know if we appended a 0 or a 1 at each step, and so we store this information
    // as well in the node
    //
    // Also we need not re-visit nodes when we have seen the (value % num) already. The reason being any
    // additional digits we add from now will only make the number longer and we already are tracking
    // the path for this same modulo result we've seen earlier.
    public String multiple(int N) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(1 % N, 1, null));
        boolean visited[] = new boolean[N];
        Node dest = null;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (visited[node.val]) {
                continue;
            }
            if (node.val == 0) {
                dest = node;
                break;
            }
            queue.add(new Node((node.val * 10) % N, 0, node));
            queue.add(new Node((node.val * 10 + 1) % N, 1, node));
            visited[node.val] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (dest != null) {
            sb.append(dest.digit);
            dest = dest.parent;
        }
        
        return sb.reverse().toString();
    }
}
