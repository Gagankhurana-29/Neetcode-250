class Solution {
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int buy = prices[0];
        for(int p : prices)
        {
            if(p<buy)
            {
                buy = p;
            }
            else{
                ans = Math.max(ans,p-buy);
            }
        }
        return ans; 
    }
}
