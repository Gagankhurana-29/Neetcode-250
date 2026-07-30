class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g; i<n&&j<n; i++,j++)
            {
                if(g==0)
                {
                    dp[i][j] = true;
                }
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j] = true;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                    }
                }

                if(dp[i][j] && (j-i+1 > res.length()))
                {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
