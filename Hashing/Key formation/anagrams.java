/*
Anagrams
Given an array of strings, return all groups of strings that are anagrams. 
Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
 Note: All inputs will be in lower-case. 
 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4. 
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases within the group. 
 Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j. 

https://www.interviewbit.com/problems/anagrams/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        if (A == null || A.isEmpty()) {
            return null;
        }
        // convert to maps
        ArrayList<TreeMap<Character, Integer>> sets = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            TreeMap<Character, Integer> chars = new TreeMap<>();
            for (char c: A.get(i).toCharArray()) {
                if (chars.containsKey(c)) {
                    chars.put(c, chars.get(c) + 1);
                } else {
                    chars.put(c, 1);
                }
            }
            sets.add(chars);
        }
        
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        
        boolean[] added = new boolean[sets.size()];
        for (int i = 0; i < sets.size(); i++) {
            if (added[i]) {
                continue;
            }
            added[i] = true;
            ArrayList<Integer> group = new ArrayList<>();
            group.add(i + 1);
            for (int j = i + 1; j < sets.size(); j++) {
                if (compareMaps(sets.get(i), sets.get(j)) 
                    && !added[j]) {
                        
                    group.add(j + 1);
                    added[j] = true;
                }
            }
            x.add(group);
        }
        
        return x;
    }
    
    boolean compareMaps(
        TreeMap<Character, Integer> l, TreeMap<Character, Integer> r) {
        
        return l.toString().equals(r.toString());
    }
}
