class FreqStack {
    Map<Integer,Integer> hm;
    PriorityQueue<int[]> pq;
    int index;
    public FreqStack() {
        hm = new HashMap<>();
        pq = new PriorityQueue<>((a,b)-> a[0] != b[0] ? Integer.compare(b[0],a[0]) : Integer.compare(b[1],a[1]));
        index=0;
    }
    
    public void push(int val) {
        hm.put(val,hm.getOrDefault(val,0)+1);
        pq.offer(new int[]{hm.get(val),index++,val});
    }
    
    public int pop() {
        int[] values = pq.poll();
        hm.put(values[2],hm.get(values[2])-1);
        return values[2];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */