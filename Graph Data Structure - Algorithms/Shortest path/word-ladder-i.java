/*
Word Ladder I

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary
Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note that we account for the length of the transformation path instead of the number of transformation itself.

 Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

https://www.interviewbit.com/problems/word-ladder-i/
*/

public class Solution {
    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        int n = dictV.size();
        if (n == 0) {
            return 0;
        }
        boolean[] visited = new boolean[n];
        char[][] graph = new char[n][];
        for (int i = 0; i < n; i++) {
            graph[i] = new char[n];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String s1 = dictV.get(i);
                String s2 = dictV.get(j);
                if (adj(s1, s2)) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                print(graph[i][j]);
            }
            println();
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tmpqueue = new LinkedList<>();
        queue.add(n - 2); // start
        visited[n - 2] = true;
        int steps = 1;
        if (start.equals(end)) {
            steps = 0;
        }
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int i = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (graph[i][j] == 1 && !visited[j]) {
                        if (j == n - 1) { // end
                            print(i);
                            println();
                            return steps + 1;
                        }
                        visited[j] = true;
                        tmpqueue.add(j);
                    }
                }
            }
            steps++;
            queue.addAll(tmpqueue);
            tmpqueue.clear();
        }
        return 0;
    }
    
    boolean adj(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dist++;
            }
        }
        return (dist <= 1);
    }
    
    void print(int i) {
        //System.out.print(i + " ");
    }
    void println() {
        //System.out.println();
    }
}
