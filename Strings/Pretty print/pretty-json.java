/*
Pretty Json

Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    } 
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not 
have “\n” character in them.

https://www.interviewbit.com/problems/pretty-json/
*/

public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder row = new StringBuilder();
        for (char c: A.toCharArray()) {
            if (c != ' ') {
                row.append(c);
            }
        }
        A = row.toString();
        int N = A.length();
        row = new StringBuilder();
        int t = 0; // indents
        for (int i = 0; i < N; i++) {
            char c = A.charAt(i);
            switch (c) {
                case '[':
                case '{':
                    addLine(res, row);
                    addChar(row, t, c);
                    addLine(res, row);
                    t++;
                    break;
                case ']':
                case '}':
                    addLine(res, row);
                    t--;
                    addChar(row, t, c);
                    if (i < N - 1 && A.charAt(i + 1) == ',') {
                        // ',' is on the same line right after brace
                        break;
                    } 
                    addLine(res, row);
                    break;
                case ',':
                    addChar(row, t, c);
                    addLine(res, row);
                    break;
                default:
                    addChar(row, t, c);
                    break;
            }
        }
        return res;
    }
    
    void addChar(StringBuilder row, int t, char c) {
        if (row.length() == 0) {
            for (int i = 0; i < t; i++) {
                row.append('\t');
            }
        }
        row.append(c);
    }
    
    void addLine(ArrayList<String> result, StringBuilder row) {
        if (row.length() > 0) {
            result.add(row.toString());
            row.setLength(0);
        }
    }
}
