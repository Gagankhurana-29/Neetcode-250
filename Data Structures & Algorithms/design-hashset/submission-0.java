class MyHashSet {
     
     int[][] hashSet;

    public MyHashSet() {
        hashSet = new int[1001][1001];
    }
    
    public int colHash(int n){
        return n % hashSet.length;
    }

    public int rowHash(int n){
        return n / hashSet.length;
    }

    public void add(int key) {
        int r = rowHash(key);
        int c = colHash(key);
        hashSet[r][c] = key;
    }
    
    public void remove(int key) {
         int r = rowHash(key);
        int c = colHash(key);
        hashSet[r][c] = 0;
    }
    
    public boolean contains(int key) {
         int r = rowHash(key);
        int c = colHash(key);
        if(hashSet[r][c]!=0) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */