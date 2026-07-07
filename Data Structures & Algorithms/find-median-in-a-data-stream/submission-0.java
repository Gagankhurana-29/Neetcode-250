class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->a-b);
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
       maxHeap.offer(num);
        
        // Step 2: Balance - move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Ensure maxHeap has equal or one more element
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if((minHeap.size()+maxHeap.size())%2==0)
        {
            return (double)((minHeap.peek()+maxHeap.peek())/2.0);
        }
         return (double)(maxHeap.peek()); 
    }  
}
