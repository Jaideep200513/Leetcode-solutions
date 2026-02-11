/*
155. Min Stack

Approach :
1. We use two stacks:
    Main Stack → Stores all elements.
    Min Stack → Stores the minimum element at each stage.

2. Logic

a. push(val)
    Push value into main stack.
    If min stack is empty or val <= current minimum, push it into min stack.

b. pop()
    Pop from main stack.
    If popped value equals min stack top, pop from min stack too.

c. top()
    Return main stack top.

d. getMin()
    Return min stack top (current minimum).
  
*/

class MinStack {

    Stack<Integer> stack, minstack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty() || minstack.peek() >= val) {
            minstack.push(val);
        }
    }
    
    public void pop() {
        int t = stack.pop();

        if (t == minstack.peek()) {
            minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
