class Solution {

    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        int total = 0;
        for(int p : piles){
            total += p;
        }

        int l=0, r=piles.length-1;
        int ascore = dfs(l,r,piles);
        return ascore > total-ascore;
    }

    private int dfs(int l,int r, int[] piles){
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        boolean even = (r-l)%2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        dp[l][r] = Math.max(dfs(l+1,r,piles) + left, dfs(l,r-1,piles)+right);
        return dp[l][r]; 
    }
}