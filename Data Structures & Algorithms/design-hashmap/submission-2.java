class MyHashMap {

    class Node
    {
        private int k;
        private int v;
        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }
    }

    public Node[] nodes;

    public MyHashMap() {
        nodes = new Node[1000001];
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        nodes[key] = node;
    }
    
    public int get(int key) {
        if(nodes[key] == null)
        {
            return -1;
        }
        Node node =  nodes[key];
        return node.v;
    }
    
    public void remove(int key) {
        nodes[key] = null; 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */