/*
Possibility of finishing all courses given pre-requisites

Problem Setter: mihai.gheorghe Problem Tester: sneh_gupta
 There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites,
 for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2]. 
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. 
return 1/0 if it is possible/not possible.
The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following order: 1, 2 
 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], then it is not possible for you to finish all the courses.
 
https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
*/

public class Solution {
    // Based on https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
    // Another solution could be https://en.wikipedia.org/wiki/Topological_sorting
    public int solve(int N, ArrayList<Integer> A, ArrayList<Integer> B) {
        List<List<Integer>> g = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            g.add(new LinkedList<>());
        }
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i);
            int b = B.get(i);
            g.get(a - 1).add(b - 1);
        }
        boolean visited[] = new boolean[N];
        boolean stack[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!dag(i, g, visited, stack)) {
                return 0;
            }
        }
        return 1;
    }
    
    boolean dag(int root, List<List<Integer>> g, boolean visited[], boolean stack[]) {
        int N = visited.length;
        List<Integer> adj = g.get(root);
        for (int j : adj) {
            if (stack[j]) {
                print("cycle at " + j);
                return false;
            }
            if (visited[j]) {
                continue;
            }
            stack[j] = true;
            visited[j] = true;
            print("visited " + j);
            if (!dag(j, g, visited, stack)) {
                return false;
            }
            stack[j] = false;
        }
        return true;
    }

    void print(String s) {
        //System.out.println(s);
    }
}

