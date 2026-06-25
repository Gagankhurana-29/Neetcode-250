class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]); // minheap from 
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        
        int currCap=0;
        for(int[] trip : trips)
        {
            int cap = trip[0];
            int from = trip[1];
            int to = trip[2];

            while(!pq.isEmpty() && from>=pq.peek()[2])
            {
                cap -= pq.poll()[0];
            }

            pq.offer(trip);
            currCap += cap;
            if(currCap>capacity) return false; 
        }

        return true;
    }
}