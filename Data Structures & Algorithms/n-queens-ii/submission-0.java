class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        int[][] board = new int[n][n];
        backtrack(board,0,n);
        return ans;
    }

    public void backtrack(int[][] board,int i,int n){
        if(i==n){
            ans++;
            return;
        }
        for(int k=0;k<n;k++){
            if(isSafe(board,i,k)){
                board[i][k] = 1;
                backtrack(board,i+1,n);
                board[i][k] = 0;
            }
        }
    }

    public boolean isSafe(int[][] board, int r, int c){
        for(int i=r;i>=0;i--){
            if(board[i][c]==1) return false;
        }
        for(int i=r,j=c; i>=0 && j>=0; i--,j--){
            if(board[i][j]==1) return false;
        }
         for(int i=r,j=c; i>=0 && j<board.length; i--,j++){
            if(board[i][j]==1) return false;
        }
        return true;
    }
}