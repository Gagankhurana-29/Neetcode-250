class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int t = curr[0];
            int x = curr[1];
            int y = curr[2];

            visited[x][y] = true;

            if(x==grid.length-1 && y==grid[0].length-1) return t;

            for(int[] dir : dirs)
            {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx<0 || ny<0 || nx>=grid.length || ny>=grid[0].length 
                  || visited[nx][ny]) continue;
                int nt = Math.max(t,grid[nx][ny]);
                pq.offer(new int[]{nt,nx,ny});
            }
        }

        return -1;

    }
}
