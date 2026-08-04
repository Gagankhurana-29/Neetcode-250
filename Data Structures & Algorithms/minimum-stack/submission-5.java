class MinStack {

    Stack<Integer> st;
    Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val)
        {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(st.peek().equals(minStack.peek()))
        {
            st.pop();
            minStack.pop();
        }
        else{
            st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
