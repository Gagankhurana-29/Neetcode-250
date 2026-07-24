class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        int maxLen = 0 ;
        for(String str : wordDict)
        {
            maxLen = Math.max(maxLen,str.length());
        }

        dp[0] = true;
        for(int i=1;i<=s.length();i++)
        {
            for(int j=i-1; j>=0;j--)
            {
                if(dp[j] && hs.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
