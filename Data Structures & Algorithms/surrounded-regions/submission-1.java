class Solution {
    public void solve(char[][] board) {
     int r = board.length;
     int c = board[0].length;
     Queue<int[]> qu = new LinkedList<>();
     for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            if((i==0 || j==0 || i==r-1 || j==c-1) && board[i][j]=='O'){
                qu.offer(new int[]{i,j});
            }
        }
     }

     boolean[][] unmodifiable = new boolean[r][c];
     int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

     while(!qu.isEmpty()){
        int[] curr = qu.poll();
        int x = curr[0];
        int y = curr[1];
        unmodifiable[x][y] = true;
        for(int[] dir : dirs){
            int u = x + dir[0];
            int v = y + dir[1];
            if(u<0 || v<0 || u>=r || v >=c || board[u][v]=='X' || unmodifiable[u][v]){
                continue;
            }
            unmodifiable[u][v] = true;
            qu.offer(new int[]{u,v});
        }
     }
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(unmodifiable[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
