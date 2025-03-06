class MyStack {

    Queue<Integer> mainQueue = new LinkedList<Integer>();
	Queue<Integer> subQueue = new LinkedList<Integer>();
	
	public MyStack() {
        
    }
    
    public void push(int x) {
        mainQueue.add(x);
    }
    
    public int pop() {
        while (mainQueue.size()>1) {
			subQueue.add(mainQueue.remove());
		}
        int val = mainQueue.remove();

        Queue<Integer> temp = mainQueue;
        mainQueue = subQueue;
        subQueue = temp;
        return val;
    }
    
    public int top() {
    	while (mainQueue.size()>1) {
			subQueue.add(mainQueue.remove());
		}
        int val = mainQueue.remove();
        subQueue.add(val);

        Queue<Integer> temp = mainQueue;
        mainQueue = subQueue;
        subQueue = temp;
        return val;
    }
    
   public boolean empty() {
        return mainQueue.isEmpty() && subQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */