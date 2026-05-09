class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    ans++;
                    isConnectiveLand(grid,i,j,visited);
                }
            }
        }
        return ans;
    }

    public void isConnectiveLand(char[][] grid, int i,int j, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j] || grid[i][j]=='0'){
            return;
        }       
        visited[i][j]=true;
         isConnectiveLand(grid,i-1,j,visited);
         isConnectiveLand(grid,i+1,j,visited); 
         isConnectiveLand(grid,i,j-1,visited);
         isConnectiveLand(grid,i,j+1,visited);     
    }

}