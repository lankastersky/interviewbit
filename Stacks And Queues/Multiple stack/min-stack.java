/*
Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor. 

https://www.interviewbit.com/problems/min-stack/
*/

class Solution {
    Stack<Integer> stack;
    //Map<Integer, Integer> mins; // Gets OOM.
    Stack<Integer> minStack;
    
    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
        //mins = new HashMap<>();
    }
    
    public void push(int x) {
        //int size = mins.size();
        int min;
        if (minStack.isEmpty()) {
            min = x;
        } else {
            int prev = minStack.peek();
            min = Math.min(prev, x);
        }
        //mins.put(size + 1, min);
        minStack.push(min);
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();
        //mins.remove(mins.size());
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        //return mins.get(mins.size());
        return minStack.peek();
    }
}
