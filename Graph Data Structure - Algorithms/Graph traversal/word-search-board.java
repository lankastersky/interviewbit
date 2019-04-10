/*
Word Search Board

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
or vertically neighboring. The cell itself does not count as an adjacent cell. 
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.

https://www.interviewbit.com/problems/word-search-board/
*/

public class Solution {
    public int exist(ArrayList<String> A, String B) {
        int res = 0;
        int n = A.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A.get(0).length(); j++) {
                if (check(A, B, i, j, 0) == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
    
    int check(ArrayList<String> A, String B, int x, int y, int i) {
        if (i == B.length()) {
            return 1;
        }
        String s = A.get(x);
        if (s.charAt(y) != B.charAt(i)) {
            return 0;
        }
        int res = 0;
        if (x > 0) {
            res = check(A, B, x - 1, y, i + 1);
            if (res == 1) {
                return 1;
            }
        }
        if (x + 1 < A.size()) {
            res = check(A, B, x + 1, y, i + 1);
            if (res == 1) {
                return 1;
            }
        }
        if (y > 0) {
            res = check(A, B, x, y - 1, i + 1);
            if (res == 1) {
                return 1;
            }
        }
        if (y + 1 < A.get(0).length()) {
            res = check(A, B, x, y + 1, i + 1);
            if (res == 1) {
                return 1;
            }
        }
        return 0;
    }
}
