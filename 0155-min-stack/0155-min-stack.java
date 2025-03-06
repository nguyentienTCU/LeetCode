class MinStack {
    private List<int[]> stack;
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        int[] top = new int[2];
        if(stack.isEmpty()){
            top[0] = val;
            top[1] = val;
        }else{
            top[0] = val;
            top[1] = Math.min(val, stack.get(stack.size()-1)[1]);
        }
        stack.add(top);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1)[0];
    }
    
    public int getMin() {
        return stack.get(stack.size()-1)[1];
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