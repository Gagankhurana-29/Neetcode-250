class Solution {
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0; j<n;j++){
                board[i][j] = '.';
            }
        }

        backTrack(0,n, board);
        return res;
    }

    public void backTrack(int r, int n, char[][] board){
        if(r==n){
           List<String> ans = new ArrayList<>();
           for(char[] q : board){
             ans.add(new String(q));
           }
           res.add(new ArrayList<>(ans));
           return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(r,c,board)){
                board[r][c] = 'Q';
                backTrack(r+1,n,board);
                board[r][c] = '.';
            }
        }
    }

    public boolean isSafe(int r, int c, char[][] board){
        for(int i=r-1; i>=0; i--){
            if(board[i][c]== 'Q') return false;
        }
        for(int i=r-1,j=c-1; i>=0 && j>=0; i--,j--){
             if(board[i][j]== 'Q') return false;
        }
         for(int i=r-1,j=c+1; i>=0 && j<board.length; i--,j++){
             if(board[i][j]== 'Q') return false;
        }
        return true;
    }
}
