class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] al = new boolean[r][c];
        boolean[][] pf = new boolean[r][c];

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<c;i++){
            dfs(0,i,heights,pf,heights[0][i]);
            dfs(r-1,i,heights,al,heights[r-1][i]);
        }

        for(int i=0;i<r;i++){
            dfs(i,0,heights,pf,heights[i][0]);
            dfs(i,c-1,heights,al,heights[i][c-1]);
        }

          for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(al[i][j] && pf[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

   public void dfs(int i, int j, int[][] heights, boolean[][] ocean, int curr){
    ocean[i][j] = true;
    for(int[] dir : dirs){
        int x = i + dir[0];
        int y = j + dir[1];
        if(x<0 || y<0 || x>=heights.length || y>=heights[0].length
         || heights[x][y]<curr || ocean[x][y]){
          continue;  
        }
        else{
            dfs(x,y,heights,ocean,heights[x][y]);
        }
    }
   }

}
