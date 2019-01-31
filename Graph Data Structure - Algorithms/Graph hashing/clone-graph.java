/*
Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

https://www.interviewbit.com/problems/clone-graph/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    Map<UndirectedGraphNode, UndirectedGraphNode> memo = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        //memo.add(node);
        clone(node, cloned);
        return cloned;
    }
    
    void clone(UndirectedGraphNode node, UndirectedGraphNode cloned) {
        if (memo.containsKey(node)) {
            return;
        }
        memo.put(node, cloned);
        for (UndirectedGraphNode child: node.neighbors) {
            UndirectedGraphNode clonedChild;
            if (memo.containsKey(child)) {
                clonedChild = memo.get(child);
            } else {
                clonedChild = new UndirectedGraphNode(child.label);
            }
            cloned.neighbors.add(clonedChild);
            //System.out.println("p,c:" + cloned.label + "," + clonedChild.label);
            clone(child, clonedChild);
        }
    }
}
