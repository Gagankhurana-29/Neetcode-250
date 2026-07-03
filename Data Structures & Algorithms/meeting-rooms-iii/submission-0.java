class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(
            (a,b) -> (a[1]==b[1] ? a[0]-b[0] : a[1]-b[1])
        );

        int[] count = new int[n];
        for(int i=0;i<n;i++) freeRooms.offer(i);

        for(int[] meet : meetings)
        {
            int startTime = meet[0];
            int endTime = meet[1];
            while(!busyRooms.isEmpty() && busyRooms.peek()[1]<=startTime)
            {
                int[] curr = busyRooms.poll();
                freeRooms.offer(curr[0]);
            }
            if(!freeRooms.isEmpty())
            {
                int room = freeRooms.poll();
                busyRooms.offer(new int[]{room,endTime});
                count[room]++;
            }
            else{
                int[] curr = busyRooms.poll();
                int room = curr[0];
                int newEnd = curr[1] + (endTime-startTime);
                busyRooms.offer(new int[]{room,newEnd});
                count[room]++;
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++)
        {
            if(count[i]>count[ans]) ans=i;
        } 
        return ans;
    }
}