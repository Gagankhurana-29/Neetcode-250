class LFUCache {
    int capacity;
    int minFreq = 0; 

    class Node{
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        public Node(int k, int v){
            this.key = k;
            this.value = v;
            this.freq = 1;
        }
    }

    class DoublyLinkedList{

            Node head, tail;

            int size = 0;

        public DoublyLinkedList(){
            head = new Node(-1,-1);
            tail = new Node (-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void addFront(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeAtLast(){
            if(size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public boolean isEmpty(){
            return size==0;
        }

    }

    Map<Integer, Node>  cache;
    Map<Integer, DoublyLinkedList> freqMap; 

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void updateFreq(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList olist = freqMap.get(oldFreq);
        olist.remove(node);
        if(oldFreq == minFreq && olist.isEmpty()){
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList dl = freqMap.computeIfAbsent(node.freq, k->new DoublyLinkedList());
        dl.addFront(node);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
         if(capacity == 0) return;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            updateFreq(node);
        }
        // if capacity is full
        else{
                if(cache.size() == capacity){
                DoublyLinkedList dl = freqMap.get(minFreq);
                Node toRemove  = dl.removeAtLast();
                if(toRemove != null){
                    cache.remove(toRemove.key);
                }
                if(dl.isEmpty()){
                    freqMap.remove(minFreq);
                }
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1;
            DoublyLinkedList list = freqMap.computeIfAbsent(1, k -> new DoublyLinkedList());
            list.addFront(newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */