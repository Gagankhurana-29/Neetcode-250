class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int count = 1,index=1;
        while(true){
            index =(int)Math.pow(count,2);
            if(index>n) break;
            dp[index] = 1;
            count++;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i/2;j++){
                dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
            }
        }
        return dp[n];
    }
}