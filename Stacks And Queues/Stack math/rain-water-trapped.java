/*
Rain Water Trapped

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example :

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

https://www.interviewbit.com/problems/rain-water-trapped/
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int n = A.size();
        if (n < 3) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack();
        int level = A.get(0);
        for (int i = 0; i < n; i++) {
            int el = A.get(i);
            if (stack.isEmpty() || el < level) {
                stack.push(el);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() < level) {
                int cur = stack.pop();
                res += (level - cur);
                //System.out.println("i, res: " + i + "," + res);
            }
            stack.push(el);
            level = el;
        }
        if (stack.isEmpty()) {
            return res;
        }
        level = stack.peek();
        //System.out.println("level: " + level);
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            int el = stack.pop();
            //System.out.println("el: " + el);
            if (stack2.isEmpty() || el < level) {
                stack2.push(el);
                continue;
            }
            if (el >= level) {
                while (!stack2.isEmpty() && stack2.peek() < level) {
                    int cur = stack2.pop();
                    res += (level - cur);
                    //System.out.println("el, res: " + el + "," + res);
                }
                stack2.push(el);
                level = el;
                //System.out.println("level: " + el);
            }
        }
        return res;
    }
}
