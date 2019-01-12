/*
Substring Concatenation

You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).

https://www.interviewbit.com/problems/substring-concatenation/
*/

    public class Solution {
        public ArrayList<Integer> findSubstring(String A, final List<String> B) {
            if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
                return new ArrayList<>();
            }
            Map<String, Integer> map = new HashMap<>();
            for (String s: B) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
            int wordsize = B.get(0).length();
            int l = wordsize * B.size();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < A.length() - l + 1; i++) {
                //String subs = A.substring(i, i + l);
                Map<String, Integer> rows = new HashMap<>(map);
                boolean found = true;
                for (int j = 0; j < B.size(); j++) {
                    int start = i + j * wordsize;
                    String subs = A.substring(start, start + wordsize);
                    if (!rows.containsKey(subs) || rows.get(subs) == 0) {
                        found = false;
                        break;
                    }
                    rows.put(subs, rows.get(subs) - 1);
                }
                if (found) {
                    res.add(i);
                }
            }
            return res;
        }


        // Gives TLE.
//        // DO NOT MODIFY THE LIST. IT IS READ ONLY
//        public ArrayList<Integer> findSubstring(String A, final List<String> B) {
//            if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
//                return new ArrayList<>();
//            }
//            int[] current = new int[B.size()];
//            Set<String> concats = new HashSet<>();
//            Set<Integer> res = new TreeSet<>();
//            genconcats(A, res, B, concats, 0, current);
//            ArrayList<Integer> result = new ArrayList<>(res);
//            //Collections.sort(res);
////            for (String c: concats) {
////                System.out.println(c);
////            }
////            System.out.println("-");
//            // Gives OOM.
////            int subsl = concats.iterator().next().length();
////            for (int i = 0; i < A.length() - subsl + 1; i++) {
////                String subs = A.substring(i, i + subsl);
////                if (concats.contains(subs)) {
////                    res.add(i);
////                }
////            }
//            return result;
//        }
//
//        void testSubstr(String A, String concat, Set<Integer> res) {
//            int subsl = concat.length();
//            for (int i = 0; i < A.length() - subsl + 1; i++) {
//                String subs = A.substring(i, i + subsl);
//                if (concat.equals(subs) && !res.contains(i)) {
//                    res.add(i);
//                    break;
//                }
//            }
//        }
//
//        void genconcats(
//                String A,
//                Set<Integer> res,
//                List<String> a,
//                Set<String> concats,
//                int step,
//                int[] current) {
//
//            if (step == a.size()) {
//                StringBuilder b = new StringBuilder();
//                for (int i = 0; i < a.size(); i++) {
//                    b.append(a.get(current[i]));
//                }
////                concats.add(b.toString());
//                testSubstr(A, b.toString(), res);
//                return;
//            }
//            for (int i = 0; i < a.size(); i++) {
//                boolean found = false;
//                for (int j = 0; j < step; j++) {
//                    if (current[j] == i) {
//                        found = true;
//                        break;
//                    }
//                }
//                if (found) {
//                    continue;
//                }
//                current[step] = i;
//                genconcats(A, res, a, concats, step + 1, current);
//            }
//        }
    }

