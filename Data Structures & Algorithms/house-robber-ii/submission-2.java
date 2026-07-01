class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        int max = 0;
        int n = nums.length;
        dp[0] = nums[0];
        max= Math.max(max,dp[0]);
        for(int i=1;i<nums.length-1;i++){
            if(i==1)
            {
                dp[i] = nums[i];
            }
            else{
                dp[i]= nums[i] + dp[i-2];
            }
            dp[i] = Math.max(dp[i],dp[i-1]);
            max = Math.max(max,dp[i]);
        }

    dp[nums.length-1] = nums[n-1];
    max = Math.max(max,dp[nums.length-1]);
    for(int i=nums.length-2;i>=1;i--)
    {
        if(i==nums.length-2) dp[i]=nums[i];
        else dp[i] = nums[i] + dp[i+2];
        dp[i] = Math.max(dp[i],dp[i+1]);
        max = Math.max(max,dp[i]);
    }
    return max;
    }
}
