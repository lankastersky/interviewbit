/*
Commutable Islands

There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each 
other.

Example :
Input
         Number of islands ( n ) = 4
         1 2 1 
         2 3 4
         1 4 3
         4 3 2
         1 3 10
In this example, we have number of islands(n) = 4 . Each row then represents a bridge configuration. In each row first two 
numbers represent the islands number which are connected by this bridge and the third integer is the cost associated with 
this bridge.

In the above example, we can select bridges 1(connecting islands 1 and 2 with cost 1), 3(connecting islands 1 and 4 with cost
3), 4(connecting islands 4 and 3 with cost 2). Thus we will have all islands connected with the minimum possible 
cost(1+3+2 = 6). 
In any other case, cost incurred will be more.

https://www.interviewbit.com/problems/commutable-islands/
*/

public class Solution {
    
    class Edge {
        int a; // vertex 1
        int b; // vertex 2
        int w; // weight
        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    
    class DSet {
        Integer parents[];
        DSet(int N) {
            parents = new Integer[N];
        }
        
        int find(int v) {
            int res = v;
            while (parents[res] != null) {
                res = parents[res];
            }
            return res;
        }
        
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            parents[pb] = pa;
        }
    }
    
    // Based on https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        if (A == 0) {
            return 0;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for (ArrayList<Integer> raw: B) {
            int a = raw.get(0) - 1;
            int b = raw.get(1) - 1;
            int w = raw.get(2);
            edges.add(new Edge(a, b, w));
        }
        Collections.sort(edges, (Edge e1, Edge e2) -> Integer.compare(e1.w, e2.w));
        
        int res = 0;
        DSet dset = new DSet(A);
        for (Edge edge: edges) {
            println(edge.a + " " + edge.b + " " + edge.w);
            int a = dset.find(edge.a);
            int b = dset.find(edge.b);

            if (dset.find(a) == dset.find(b)) {
                continue;
            }

            dset.union(a, b);
            res += edge.w;
        }
        return res;
    }

    void print(String i) {
        //System.out.print(i + " ");
    }
    
    void println(String i) {
        //System.out.println(i);
    }
}
