/*
Ways to color a 3xN Board

Problem Setter: raghav_aggiwal Problem Tester: glowing_glare
Given a 3Xn board, find the number of ways to color it using at most 4 colors such that no two adjacent boxes have same color. Diagonal neighbors are not treated as adjacent boxes. 
Output the ways%1000000007 as the answer grows quickly.

1<= n < 100000

Example:
Input: n = 1
Output: 36

https://www.interviewbit.com/problems/ways-to-color-a-3xn-board/
*/

public class Solution {
    int C = 4;
    int base = 1000000007;

    class Triplet {
        final int i;
        final int j;
        final int k;
        Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    
    public int solve(int n) {
        if (n == 0) {
            return 0;
        }
        List<Triplet> triplets = buildTriplets();
        // i_j_k - res for given column
        //Map<Triplet, Integer> [] list = (Map<Triplet, Integer>[]) new HashMap[n];
        int[][][][] list = new int[n + 1][][][];
        for (int c = 0; c <= n; c++) {
            list[c] = new int[C][][];
            for (int i = 0; i < C; i++) {
                list[c][i] = new int[C][];
                for (int j = 0; j < C; j++) {
                    list[c][i][j] = new int[C];
                }
            }
        }
        int s = triplets.size();
        //Map<Triplet, Integer> map = new HashMap<>(s, 1);
        //list[0] = map;
        // for (Triplet t: triplets) {
        //     map.put(t, 1);
        // }
        
        for (int i = 1; i <= n; i++) {
            // map = new HashMap<>(s, 1);
            // list[i] = map;
            for (int j = 0; j < s; j++) {
                int temp = 0;
                Triplet tj = triplets.get(j);
                if (i == 1) {
                    list[i][tj.i][tj.j][tj.k] = 1;
                    continue;
                }
                for (int k = 0; k < s; k++) {
                    Triplet tk = triplets.get(k);
                    if (compatible(tj, tk)) {
                        //temp = (temp + list[i - 1].get(tk)) % base;
                        temp = (temp + list[i - 1][tk.i][tk.j][tk.k]) % base;
                    }
                }
                // map.put(tj, temp);
                list[i][tj.i][tj.j][tj.k] = temp;
            }
        }
        
        int res = 0;
        // map = list[n - 1];
        for (Triplet t: triplets) {
            // res = (res + map.get(t)) % base;
            res = (res + list[n][t.i][t.j][t.k]) % base;
        }
        
        return res;
    }
    
    boolean compatible(Triplet t1, Triplet t2) {
        return (t1.i != t2.i && t1.j != t2.j && t1.k != t2.k);
    }
    
    List<Triplet> buildTriplets() {
        List<Triplet> list = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < C; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < C; k++) {
                    if (j == k) {
                        continue;
                    }
                    Triplet t = new Triplet(i, j, k);
                    list.add(t);
                }
            }
        }
        return list;
    }
    
    // Gives Stack overflow
    // // i_j_k - combinations of i, j, k
    // Map<String, List<List<Integer>>> map = new HashMap<>();
    // List<List<Integer>> list = new ArrayList<>();

    // public int solve(int n) {
    //     if (n == 0) {
    //         return 0;
    //     }
    //     fillMap();
    //     if (n == 1) {
    //         return list.size();
    //     }
    //     for (int c = 2; c <= n; c++) {
    //         List<List<Integer>> list2 = new ArrayList<>();
    //         for (List<Integer> l: list) {
    //             int i = l.get(0);
    //             int j = l.get(1);
    //             int k = l.get(2);
    //             String key = String.format("%d_%d_%d", i, j, k);
    //             if (!map.containsKey(key)) {
    //                 System.out.println("key absent:" + key);
    //             }
    //             list2.addAll(map.get(key));
    //         }
    //         list = list2;
    //     }
    //     return list.size();
    // }

    // void fillMap() {
    //     int res = 0;
    //     /*
    //         i0 | i | ...
    //         j0 | j | ...
    //         k0 | k | ...
    //     */
    //     for (int i = 0; i < C; i++) {
    //         for (int j = 0; j < C; j++) {
    //             if (i == j) {
    //                 continue;
    //             }
    //             for (int k = 0; k < C; k++) {
    //                 if (j == k) {
    //                     continue;
    //                 }
    //                 List<Integer> l = new ArrayList<>();
    //                 l.add(i);
    //                 l.add(j);
    //                 l.add(k);
    //                 list.add(l);
    //             }
    //         }
    //     }    
    //     int res2 = 0;
    //     for (List<Integer> l: list) {
    //         int i0 = l.get(0);
    //         int j0 = l.get(1);
    //         int k0 = l.get(2);
    //         List<List<Integer>> c = new ArrayList<>();        
    //         String key = String.format("%d_%d_%d", i0, j0, k0);
    //         if (map.containsKey(key)) {
    //             System.out.println("key present:" + key);
    //         }
    //         map.put(key, c);
    //         for (int i = 0; i < C; i++) {
    //             if (i == i0) {
    //                 continue;
    //             }
    //             for (int j = 0; j < C; j++) {
    //                 if (j == j0) {
    //                     continue;
    //                 }
    //                 if (i == j) {
    //                     continue;
    //                 }
    //                 for (int k = 0; k < C; k++) {
    //                     if (k == k0) {
    //                         continue;
    //                     }
    //                     if (j == k) {
    //                         continue;
    //                     }
    //                     List<Integer> list2 = new ArrayList<>();
    //                     list2.add(i);
    //                     list2.add(j);
    //                     list2.add(k);
    //                     c.add(list2);
    //                 }
    //             }
    //         }
    //         //System.out.println(key + ":" + map.get(key).size());
    //         res2 += map.get(key).size();
    //     }
    //     //System.out.println("res:" + res2);
    // }
}
