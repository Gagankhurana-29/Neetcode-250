class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
    
        boolean[][] visited = new boolean[r][c];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!pq.isEmpty()){
            
            int[] curr = pq.poll();
            
            int effort=curr[0], x=curr[1] , y=curr[2];

            if(visited[x][y]) continue;

            visited[x][y] = true;

            if(x==r-1 && y==c-1) return effort;
            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx<0 || ny <0 || nx>=r || ny>=c){
                    continue;
                } 
                int newEffort = Math.max(effort,Math.abs(heights[nx][ny] - heights[x][y]));
                pq.offer(new int[]{newEffort,nx,ny});
            }
        }
        return 0;
    }
}