/*
N max pair combinations

Problem Setter: dhruvi Problem Tester: ganeshk2
Given two arrays A & B of size N each.
Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6), 
9    (3+6),
9    (4+5),
8    (2+6)

https://www.interviewbit.com/problems/n-max-pair-combinations/
*/

public class Solution {
    class Pair<K, V> {
        K a;
        V b;
        Pair(K a, V b) {
            this.a = a;
            this.b = b;
        }
    }
    public ArrayList<Integer> solve(
        ArrayList<Integer> A, ArrayList<Integer> B) {
            
        int n = A.size();
        int m = B.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n * m == 0) {
            return res;
        }
        Collections.sort(A);
        Collections.sort(B);
        
        // for (int i = n - 1; i >= 0; i--) {
        //     System.out.print(A.get(i) + " ");
        // }
        // System.out.println();
        // for (int i = n - 1; i >= 0; i--) {
        //     System.out.print(B.get(i) + " ");
        // }
        // System.out.println();
        
        Comparator<Pair<Integer, Pair<Integer, Integer>>> comp = (p1, p2) -> {
            return -Integer.compare(p1.a, p2.a);
        };
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> queue = 
            new PriorityQueue<>(n, comp);
        Map<String, Boolean> map = new HashMap<>();
        Pair<Integer, Integer> ind = new Pair<>(n - 1, m - 1);
        int sum = A.get(n - 1) + B.get(m - 1);
        Pair<Integer, Pair<Integer, Integer>> pair = new Pair<>(sum, ind);
        queue.add(pair);
        String key = String.format("%s_%s", n - 1, m - 1);
        map.put(key, true);
        while (true) {
            pair = queue.poll();
            res.add(pair.a);
            if (res.size() == n) {
                return res;
            }
            ind = pair.b;
            int i = ind.a;
            int j = ind.b;
            key = String.format("%s_%s", i, j - 1);
            if (!map.containsKey(key)) {
                sum = A.get(i) + B.get(j - 1);
                ind = new Pair<>(i, j - 1);
                pair = new Pair<>(sum, ind);
                queue.add(pair);
                map.put(key, true);
            }
            key = String.format("%s_%s", i - 1, j);
            if (!map.containsKey(key)) {
                sum = A.get(i - 1) + B.get(j);
                ind = new Pair<>(i - 1, j);
                pair = new Pair<>(sum, ind);
                queue.add(pair);
                map.put(key, true);
            }
        }

        // Gives MLE.
        // PriorityQueue<Integer> queue = 
        //     new PriorityQueue<>(n, Collections.reverseOrder());
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         queue.add(A.get(i) + B.get(j));
        //     }
        // }
        
        // for (int i = 0; i < n; i++) {
        //     res.add(queue.poll());
        // }
        //return res;
    }
}
