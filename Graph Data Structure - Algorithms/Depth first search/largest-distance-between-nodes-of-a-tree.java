/*
Largest Distance between nodes of a Tree

Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. 
The goal of the problem is to find largest distance between two nodes in a tree. 
Distance between two nodes is a number of edges on a path between the nodes 
(there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). 
Exactly one of the i’s will have P[i] equal to -1, it will be root node.

 Example:
If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 
          0
       /  |  \
      1   2   3
               \
                4  
 One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus 

https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
*/

public class Solution {
    
    class Node {
        ArrayList<Node> children;
        boolean visited;
        int depth;
        Node() {
            children = new ArrayList<>();
        }
    }
    
    int max;
    
    public int solve(ArrayList<Integer> A) {
        Node g[] = new Node[A.size()];
        
        for (int i = 0; i < A.size(); i++) {
            g[i] = new Node();
        }
        Node root = null;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == -1) {
                root = g[i];
                continue;
            }
            Node l = g[i];
            Node r = g[A.get(i)];
            //l.children.add(r);
            r.children.add(l);
        }
        
        traverse(root);
        return max;
    }
    
    void traverse(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            boolean found = false;
            for (Node c: cur.children) {
                if (!c.visited) {
                    c.visited = true;
                    stack.push(c);
                    found = true;
                    break;
                }
            }
            if (!found) {
                Node leaf = stack.pop();
                leaf.depth = dist(leaf);
            }
        }
    }
    
    int dist(Node root) {
        int max1 = 0;
        int max2 = 0;
        for (Node c: root.children) {
            int res = 1 + c.depth;
            if (max1 < res) {
                max2 = max1;
                max1 = res;
            } else if (max2 < res) {
                max2 = res;
            }
        }
        max = Math.max(max, max1 + max2);
        return max1;
    }
    
    // Gives Stack overflow
    // int traverse(Node root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int max1 = 0;
    //     int max2 = 0;
    //     for (Node c: root.children) {
    //         int res = 1 + traverse(c);
    //         if (max1 < res) {
    //             max2 = max1;
    //             max1 = res;
    //         } else if (max2 < res) {
    //             max2 = res;
    //         }
    //     }
    //     max = Math.max(max, max1 + max2);
    //     return max1;
    // }
}
