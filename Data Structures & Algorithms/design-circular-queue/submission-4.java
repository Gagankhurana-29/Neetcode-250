class MyCircularQueue {

    class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head,tail;
    int len;
    int currLen=0;

    public MyCircularQueue(int k) {
        len = k;
    }
    
    public boolean enQueue(int value) {
        if(currLen==len) return false;
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
        tail.next = node;
        node.prev = tail;
        tail = node;
        }
        currLen++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(currLen == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        currLen--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return currLen == 0;
    }
    
    public boolean isFull() {
        return currLen == len;
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