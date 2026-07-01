class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()>text2.length())
        {
            return longestCommonSubsequence(text2,text1);
        }

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int r = dp.length;
        int c = dp[0].length;
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[r-1][c-1];
    }
}
