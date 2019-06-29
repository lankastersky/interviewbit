/*
Valid Ip Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)

https://www.interviewbit.com/problems/valid-ip-addresses/
*/

  public class Solution {
    public ArrayList<String> restoreIpAddresses(String A) {
      ArrayList<String> result = new ArrayList<>();
      validate(result, A, 0, new ArrayList<>());
      return result;
    }

    void validate(ArrayList<String> res, String A, int start, ArrayList<String> cur) {
      if (start == A.length()) {
        if (cur.size() != 4) {
          return;
        }
        StringBuilder ip = new StringBuilder();
        for (String octet: cur) {
          ip.append(octet);
          ip.append(".");
        }
        ip.deleteCharAt(ip.length() - 1);
        res.add(ip.toString());
        return;
      }

      for (int i = start; i < start + 3 && i < A.length(); i++) {
        String ip = A.substring(start, i + 1);
        if (valid(ip)) {
          cur.add(ip);
          validate(res, A, i + 1, cur);
          cur.remove(cur.size() - 1);
        }
      }
    }

    boolean valid(String s) {
      if (s.equals("0")) {
        return true;
      }

      // trim 0
      char c = s.charAt(0);
      if (c == '0') {
          return false;
      }

      int number = 0;
      int mul = 1;
      for (int i = s.length() - 1; i >= 0; i--) {
          int digit = (int) s.charAt(i) - '0';
          number = number + digit * mul;
          mul *= 10;
      }
      if (number > 255) {
          return false;
      }
      return true;
    }
  }
