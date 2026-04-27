class Solution {

    int sideLength;
    int[] dp ;
    int n;
    public boolean makesquare(int[] matchsticks) {
        
        int sum = Arrays.stream(matchsticks).sum();

        if(sum%4 != 0) return false;

        sideLength = sum/4;
        
         n = matchsticks.length;
         dp = new int[1<<n];
         Arrays.fill(dp,Integer.MIN_VALUE);

         return dfs((1 << n) - 1, matchsticks) == 0;
    }

    
    public int dfs(int mask, int[] matchsticks){
        if(mask == 0) return 0;
        
          if(dp[mask] != Integer.MIN_VALUE) return  dp[mask];

          for(int i=0;i<n;i++){
            if((mask & (1<<i)) != 0){
                int ans = dfs(mask ^ (1<<i), matchsticks);
                if(ans>=0 && ans + matchsticks[i]<= sideLength){
                    dp[mask] = (ans + matchsticks[i]) % sideLength;
                    return dp[mask];
                }

                if( mask == (1<<n) - 1){
                    dp[mask] = -1;
                    return -1;
                }
            }
          }
            dp[mask] = -1;
        return dp[mask];

       }
    
}