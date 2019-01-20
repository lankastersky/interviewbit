/*
Hotel Reviews

Problem Setter: ishubansal Problem Tester: raghav_aggiwal
Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]

https://www.interviewbit.com/problems/hotel-reviews/
*/

public class Solution {
    
    class TreeNode {
        final Character val;
        final List<TreeNode> children;
        boolean leaf;
        
        TreeNode(Character v) {
            val = v;
            children = new ArrayList<>();
        }
        
        TreeNode get(Character c) {
            for (TreeNode node: children) {
                if (node.val == c) {
                    return node;
                }
            }
            return null;
        }
        
        boolean isLeaf() {
            return leaf;
        }
        
        void markLeaf() {
            leaf = true;
        }
    }
    
    public ArrayList<Integer> solve(String s, ArrayList<String> B) {
        TreeNode trie = buildTrie(s);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            map.put(i, rating(trie, B.get(i)));
        }
        
        // for (int key: map.keySet()) {
        //     System.out.print("(" + key + "," + map.get(key) + ")");
        // }
        // System.out.println();
        
        List<Map.Entry<Integer, Integer>> list = 
            new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: list) {
            res.add(entry.getKey());
        }
        return res;
    }
    
    int rating(TreeNode root, String s) {
        int i = 0;
        int res = 0;
        TreeNode cur = root;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '_') {
                if (cur.isLeaf()) {
                    res++;
                }
                cur = root;
                i++;
                continue;
            }
            TreeNode child = cur.get(c);
            if (child != null) {
                cur = child;
                if (i + 1 == s.length() && cur.isLeaf()) {
                    res++;
                    break;
                }
            } else {
                // go to the next word
                //i++;
                cur = root;
                while (i < s.length() && s.charAt(i) != '_') {
                    i++;
                }
                continue;
            }
            i++;
        }
        return res;
    }
    
    TreeNode buildTrie(String s) {
        TreeNode root = new TreeNode(null);
        TreeNode cur = root;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '_') {
                cur.markLeaf();
                cur = root;
                i++;
                continue;
            }
            TreeNode child = cur.get(c);
            if (child != null) {
                cur = child;
            } else {
                child = new TreeNode(c);
                cur.children.add(child);
                cur = child;
            }
            i++;
        }
        cur.markLeaf();
        return root;
    }
}
