public class SinglyListNode {
    int val;
    SinglyListNode next;
    public SinglyListNode(int v){
        this.val = v;
    }
}

class MyLinkedList {
    private SinglyListNode head;

    public MyLinkedList() {
        this.head = null;
    }
    
    public int get(int index) {
        SinglyListNode temp = head;
        int count = 0;
        while(temp!=null){
            if(count==index){
                return temp.val;
            }

            count++;
            temp = temp.next;
        } return -1;
    }
    
    public void addAtHead(int val) {
        SinglyListNode newHeadNode = new SinglyListNode(val);
        newHeadNode.next = head;
        head = newHeadNode;
    }
    
    public void addAtTail(int val) {
        SinglyListNode tailNode = head;
        if(tailNode==null){
            addAtHead(val);
        }else{
        while(tailNode.next!=null){
            tailNode = tailNode.next;
        }

        SinglyListNode newTailNode = new SinglyListNode(val);
        tailNode.next = newTailNode;
    }
}
    
    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
        }else{
            SinglyListNode cur = head;
            SinglyListNode newNode = new SinglyListNode(val);
            int count=0;
            while(cur!=null){
                if(count==(index-1)){
                    newNode.next = cur.next;
                    cur.next = newNode;
                }

                cur = cur.next;
                count++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        SinglyListNode cur = head;
        SinglyListNode prev = null;
        int count=0;
        while(cur!=null){
            if(count==index){
                if(index==0){
                    head = head.next;
                } else {
                    prev.next = cur.next;
                }
            }

            prev = cur;
            cur = cur.next;
            count++;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */