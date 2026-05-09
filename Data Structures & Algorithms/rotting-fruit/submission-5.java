class Solution {
    public int orangesRotting(int[][] grid) {

        // if(grid.length==1 && grid[0].length==1 && (grid[0][0]==0 || grid[0][0]==-1)){
        //     return 0;
        // }

        Queue<int[]> qu = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    qu.offer(new int[]{i,j});
                }
            }
        }
        int time = -1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}}; 
        while(!qu.isEmpty())
        {
            int n = qu.size();
            while(n>0){
            int[] or = qu.poll();
            for(int[] d : dir){
                int x = or[0] + d[0];
                int y = or[1] + d[1];
                if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]==2 || grid[x][y]==0){
                  continue;    
                }
                else{
                    grid[x][y] = 2;
                    qu.offer(new int[]{x,y});
                }
              }
               n--;
            }      
            time++;
        }
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time==-1 ? 0 : time;
    }
}
