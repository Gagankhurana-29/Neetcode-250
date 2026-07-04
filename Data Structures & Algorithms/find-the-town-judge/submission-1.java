class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        for(int[] tr : trust)
        {
            int u = tr[0];
            int v = tr[1];
            outdegree[u]++;
            indegree[v]++;
        }
        int ans = 0;
        for(int i=0;i<=n;i++)
        {
            if(indegree[i]==n-1 && outdegree[i]==0) return i;
        }
        return -1;
    }
}