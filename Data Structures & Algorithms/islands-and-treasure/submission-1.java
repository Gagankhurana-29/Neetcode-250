class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(grid[i][j]==0){
                    qu.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

        //BFS
        while(!qu.isEmpty()){
            int[] dir = qu.poll();
            for(int i=0;i<directions.length;i++){
                int x = directions[i][0] + dir[0];
                int y = directions[i][1] + dir[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==-1){
                    continue;
                } 
                if (grid[x][y] == Integer.MAX_VALUE) {
                 grid[x][y] = grid[dir[0]][dir[1]] + 1;
                    qu.offer(new int[]{x, y});
                    }
            }
        }

    }
}
