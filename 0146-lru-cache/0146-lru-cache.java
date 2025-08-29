class LRUCache {
    private static class Node{
        int k;
        int v;
        Node prev;
        Node next;
        Node(int key, int value){
            this.k = key;
            this.v = value;
        }
    }

    private final int cap;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0,0);
    private final Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n==null) return -1;
        moveToHead(n);
        return n.v;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n!=null){
            n.v = value;
            moveToHead(n);
            return;
        }

        Node nn = new Node(key, value);
        addAfterHead(nn);
        map.put(key, nn);
        if(map.size() > cap){
            Node removedNode = popTail();
            map.remove(removedNode.k);
        }
    }

    //helper methods
    public void addAfterHead(Node n){
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void moveToHead(Node n){
        remove(n);
        addAfterHead(n);
    }

    private Node popTail(){
        Node n = tail.prev;
        remove(n);
        return n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */