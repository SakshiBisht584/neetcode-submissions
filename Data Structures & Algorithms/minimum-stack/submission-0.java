class MinStack {
    Stack<Integer>st;
    Stack<Integer> st2;
    public MinStack() {
        st=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!st2.isEmpty()){
            if(st2.peek()>=val){
                st2.push(val);
            }
        }
        else{
            st2.push(val);
        }
    }
    
    public void pop() {
        if(st.peek().equals(st2.peek())) st2.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
}
