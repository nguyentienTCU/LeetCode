class MyCircularQueue {
    int SIZE;
    int headIndex;
    int tailIndex;
    int[] array;
    int count;

    public MyCircularQueue(int k) {
        SIZE = k;
        headIndex = tailIndex = -1;
        array = new int[k];
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            headIndex = 0;
        }

        tailIndex++;
        if(tailIndex == SIZE){
            tailIndex = 0;
        }
        array[tailIndex] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        if(headIndex == tailIndex){
            headIndex = -1;
            tailIndex = -1;
        }

        headIndex++;
        if(headIndex == SIZE){
            headIndex = 0;
        }
        count--;
        return true;
    }
    
    public int Front() {
        return isEmpty()?-1:array[headIndex];
    }
    
    public int Rear() {
        return isEmpty()?-1:array[tailIndex];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==SIZE;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */