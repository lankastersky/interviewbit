/*
Anti Diagonals

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]

Input : 
1 2
3 4

Return the following  : 
[
  [1],
  [2, 3],
  [4]
]

https://www.interviewbit.com/problems/anti-diagonals/
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = A.size();
        if (n == 0) {
            return res;
        }
        for (int i = 1; i <= 2 * n - 1; i++) {
            ArrayList<Integer> diag = new ArrayList<>();
            res.add(diag);
            int l = i;
            if (i > n) {
                l = 2 * n - i;
            }
            int start = 0;
            if (i > n) {
                start = i - n;
            }
            int a = start;
            int b = l - a - 1;
            if (i > n) {
                b = n - 1;
            }
            for (int j = 0; j < l; j++) {
                print(a + "," + b);
                int el = A.get(a).get(b);
                //print(el + "");
                diag.add(el);
                a++;
                b--;
            }
            println();
        }
        return res;
    }
    
    void print(String s) {
        //System.out.print(s + " ");
    }
    void println() {
        //System.out.println();
    }
}
