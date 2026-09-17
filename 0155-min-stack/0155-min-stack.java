class MinStack {

    Stack<Integer> stk;
    Stack<Integer> minstk;

    public MinStack() {
        stk = new Stack<>();
        minstk = new Stack<>();
    }
    
    public void push(int value) {
        stk.push(value);
        if(minstk.isEmpty()){
            minstk.push(value);
        }
        else{
            minstk.push(Math.min(minstk.peek(), value));
        }
    }
    
    public void pop() {
        stk.pop();
        minstk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */