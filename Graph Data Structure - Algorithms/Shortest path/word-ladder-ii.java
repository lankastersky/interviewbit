/*
Word Ladder II

Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 Note:
All words have the same length.
All words contain only lowercase alphabetic characters.

https://www.interviewbit.com/problems/word-ladder-ii/
*/

public class Solution {

    // Not Optimal solution: finds all pathes using dfs and then filters by length.

/*    
Idea of the better solution : We do normal BFS as is done for calculating the shortest 
path. We only take care of all the possible parents for a node which happens in following
2 cases : 
1) Node x discovers node y and y is unvisited. x is parent of y. 
2) Node x discovers node y and y is visited and distance[y] = distance[x] + 1. 
Once we have constructed the parents, we do backtracking to construct all possible path 
combinations back from target to source.
*/
    public ArrayList<ArrayList<String>> findLadders(
        String start, String end, ArrayList<String> dict) {
        
        // Remove duplicates from dict
        dict.add(0, start);
        dict.add(end);
        Set<String> set = new HashSet<>(dict);
        dict = new ArrayList<>(set);
        int ind = -1;
        for (int i = 0; i < dict.size(); i++) {
            if (start.equals(dict.get(i))) {
                ind = i;
                break;
            }            
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        boolean visited[] = new boolean[dict.size()];
        int parents[] = new int[dict.size()];
        for (int i = 0; i < dict.size(); i++) {
            parents[i] = -1;
        }
        visited[ind] = true;
        // DFS
        findLadders(end, dict, res, ind, visited, parents);
        
        // Filters longer pathes
        int min = Integer.MAX_VALUE;
        for (ArrayList<String> path : res) {
            min = Math.min(min, path.size());
        }
        ArrayList<ArrayList<String>> res2 = new ArrayList<>();
        for (ArrayList<String> path : res) {
            if (path.size() == min) {
                res2.add(path);
            }
        }
        
        // add start node to pathes
        for (ArrayList<String> path : res2) {
            if (path.size() == 1 && path.get(0).equals(start)) {
                continue;
            }
            path.add(0, dict.get(ind));
        }
        return res2;
    }
    
    void findLadders(
        String end,
        ArrayList<String> dict, 
        ArrayList<ArrayList<String>> res,
        int ind,
        boolean visited[],
        int parents[]) {
    
        String start = dict.get(ind);    
        if (start.equals(end)) {
            addRes(res, dict, parents, ind);
            return;
        }
        
        for (int i = 0; i < dict.size(); i++) {
            if (i == ind || visited[i]) {
                continue;
            }
            String cur = dict.get(i);
            int d = dist(cur, start);
            if (d == 1) {
                visited[i] = true;
                parents[i] = ind;
                findLadders(end, dict, res, i, visited, parents);
                visited[i] = false;
                parents[i] = -1;
            }
        }
    }
    
    void addRes(
        ArrayList<ArrayList<String>> res, ArrayList<String> dict, int parents[], int ind) {
        
        ArrayList<String> path = new ArrayList<>();
        path.add(dict.get(ind));
        ind = parents[ind];
        while (ind != -1 && parents[ind] != -1) {
            path.add(0, dict.get(ind));
            ind = parents[ind];
        }
        res.add(path);
    }
    
    int dist(String s1, String s2) {
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}
