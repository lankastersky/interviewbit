/*
Justified Text

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully 
(left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces
than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 Note: Each word is guaranteed not to exceed L in length. 

https://www.interviewbit.com/problems/justified-text/
*/

public class Solution {
    public ArrayList<String> fullJustify(ArrayList<String> a, int L) {
        ArrayList<String> res = new ArrayList<>();
        int n = a.size();
        int j = 0;
        while (j < n) {
            ArrayList<String> line = new ArrayList<>();
            String s = a.get(j);
            line.add(s);
            int sum = s.length();
            j++;
            int numwords = 1;
            while (j < n && sum <= L) {
                s = a.get(j);
                if (sum + 1 + s.length() <= L) {
                    line.add(" ");
                    line.add(s);
                    sum += 1 + s.length();
                    numwords++;
                } else {
                    break;
                }
                j++;
            }
            if (sum < L) {
                // add whitespaces
                if (j == n) { // last string
                    for (int i = sum; i < L; i++) {
                        //sb.append(' ');
                        line.add(" ");
                    }
                } else {
                    int numspaces = L - sum;
                    int gaps = numwords - 1;
                    if (gaps == 0) {
                        gaps++;
                    }
                    int i = 0;
                    while (gaps > 0) {
                        int addspaces = 
                          (int) Math.ceil((double) numspaces / gaps);
                        StringBuilder w = new StringBuilder();
                        for (int k = 0; k < addspaces; k++) {
                            w.append(' ');
                        }
                        if (line.size() > 1) {
                            w.append(' '); // default whitespace
                            line.set(i * 2 + 1, w.toString());
                        } else {
                            line.add(i * 2 + 1, w.toString());
                        }
                        gaps--;
                        numspaces -= addspaces;
                        i++;
                    }
                    
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String w: line) {
                sb.append(w);
            }
            //System.out.println(sb + "|" + sb.length());
            res.add(sb.toString());
        }
        return res;
    }
}
