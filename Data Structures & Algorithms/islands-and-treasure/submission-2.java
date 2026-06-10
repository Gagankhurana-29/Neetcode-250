class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==0){
                    qu.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size>0){
            int[] tr = qu.poll();
            int r = tr[0];
            int c = tr[1];
            for(int[] dir : dirs){
                int x = r + dir[0];
                int y = c + dir[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==-1 || grid[x][y]==0 || grid[x][y] != Integer.MAX_VALUE){
                    continue;
                }
                grid[x][y] = Math.min(grid[x][y],grid[r][c]+1);
                qu.offer(new int[]{x,y});
             }
            size--;
            }
        }
    }
}
