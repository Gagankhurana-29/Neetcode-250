class Solution {
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    return dfs(grid,i,j,visited);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i,int j, boolean[][] visited){
        int r = grid.length;
        int c = grid[0].length;
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j] == 0){
            return 1;
        }       
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(grid,i+1,j,visited) + dfs(grid,i-1,j,visited) + dfs(grid,i,j-1,visited) + dfs(grid,i,j+1,visited);
    }
}