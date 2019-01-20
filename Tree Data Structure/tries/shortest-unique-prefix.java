/*
Shortest Unique Prefix

Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov

NOTE : Assume that no word is prefix of another. In other words, the 
https://www.interviewbit.com/problems/shortest-unique-prefix/
*/

public class Solution {
    
    class Node {
        final List<Node> nodes;
        Node parent;
        final Character val;
        boolean leaf;
        
        Node(Character c) {
            nodes = new ArrayList<>();
            val = c;
        }
        
        Node find(char c) {
            for (Node node: nodes) {
                if (node.val == c) {
                    return node;
                }
            }
            return null;
        }
        
        Node insert(char c) {
            Node node = new Node(c);
            node.parent = this;
            nodes.add(node);
            return node;
        }
        
        void markLeaf() {
            leaf = true;
        }
        
        boolean isLeaf() {
            return leaf;
        }
    }
    
    class Trie {
        
        final Node root;
        
        Trie() {
            root = new Node(null);
        }
        
        void insert(String s) {
            Node cur = root;
            for (char c: s.toCharArray()) {
                Node node = cur.find(c);
                if (node == null) {
                    node = cur.insert(c);
                }
                cur = node;
            }
            cur.markLeaf();
        }
        
        String findPrefix(String s) {
            Node cur = root;
            // find the leaf
            for (char c: s.toCharArray()) {
                Node node = cur.find(c);
                cur = node;
                if (node.isLeaf()) {
                    break;
                }
            }
            
            Node leaf = cur;
            
            // Go up until parent has several nodes
            int i = s.length();
            while (cur.parent != null) {
                if (cur.parent.nodes.size() > 1) {
                    break;
                }
                cur = cur.parent;
                i--;
            }
            if (i == s.length()) {
                return s;
            }
            if (i == 0) {
                i = 1;
            }
            return s.substring(0, i);
        }
    }
    
    public ArrayList<String> prefix(ArrayList<String> A) {
        Trie trie = new Trie();
        for (String s: A) {
            trie.insert(s);
        }
        
        ArrayList<String> res = new ArrayList<String>();
        for (String s: A) {
            res.add(trie.findPrefix(s));
        }
        return res;
    }
}
