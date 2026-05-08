class LRUCache {
    private int capacity;
    private final HashMap<Integer, Node> hm;
    private final Node head,tail; 

    class Node{
        int key,val;
        Node prev;
        Node next;
        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hm = new HashMap();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        removeNode(node);
        putInFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            removeNode(node);
        }
        if(hm.size()==capacity){
            removeNode(tail.prev);
        }
        Node node = new Node(key,value);
        putInFront(node);
    }

    public void removeNode(Node node){
        hm.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void putInFront(Node node){
        hm.put(node.key,node);
        node.next = head.next;
        head.next.prev = node;
        node.prev= head;
        head.next = node;
    }
}