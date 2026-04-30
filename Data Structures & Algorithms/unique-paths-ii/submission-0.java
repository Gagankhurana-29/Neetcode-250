class Solution
{
   public boolean hasSpace(int[][] arr , int i, int j)
   {
      return arr[i][j] == 0;
   }
   public int uniquePathsWithObstacles(int[][] arr)
   {
       int n = arr.length;
       int m = arr[0].length;
       if(arr[n-1][m-1] == 1) return 0;
       int[][] dp = new int[n][m];
       for(int i=n-1;i>=0; i--)
          {
	for(int j=m-1; j>=0; j--)
	   {
		if(i==n-1 && j==m-1 && hasSpace(arr,i,j))
		{
		  dp[i][j] = 1;
}
else if(i==n-1 && hasSpace(arr,i,j))
{
  dp[i][j] = dp[i][j+1];
}
else if(j==m-1 && hasSpace(arr,i,j))
{
 dp[i][j] =dp[i+1][j];
}
else{
   if(hasSpace(arr,i,j))
   { 
      dp[i][j] = dp[i+1][j] + dp[i][j+1];
    }
}
   }
          }
       return dp[0][0];
   }
}
