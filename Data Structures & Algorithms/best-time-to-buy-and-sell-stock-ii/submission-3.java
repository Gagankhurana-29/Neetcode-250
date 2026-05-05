class Solution {
    public int maxProfit(int[] prices) {
		int n = prices.length;
          int[] dp = new int[n];
		//dp[0] = 0;
         int cmax=0;
		for(int i=1;i<n;i++)
{
  if(prices[i]>prices[i-1])
{
		cmax+=prices[i]-prices[i-1];
}
}
return cmax;
    }
}

