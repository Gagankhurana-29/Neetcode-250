class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char c = word.charAt(0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==c){
                    boolean ans = dfs(board,i,j,word,1);
                    if(ans) return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};


    public boolean dfs(char[][] board, int r, int c,String word, int i){
        if(i==word.length()){
            return true;
        }
         char temp = board[r][c];
         board[r][c] = '#';
        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y] != word.charAt(i) || board[x][y] == '#'){
                continue;
            }
            boolean res = dfs(board,x,y,word,i+1);
            if(res){
                board[r][c] = temp;
                return true;   
            } 
        }
        board[r][c] = temp;
        return false;
    }
}
