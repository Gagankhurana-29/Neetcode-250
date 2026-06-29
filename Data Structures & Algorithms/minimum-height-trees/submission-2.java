class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return List.of(0);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1) qu.offer(i);
        }
        int remaining = n;
        while(remaining>2)
        {
            int size = qu.size();
            remaining-=size;
            while(size>0)
            {
                int src = qu.poll();
                indegree[src]--;
                for(int nbr : graph.get(src))
                {
                    indegree[nbr]--;
                    if(indegree[nbr]==1)
                    {
                        qu.offer(nbr);
                    }
                }
                size--;
            }
        }
        return new ArrayList<>(qu);
    }
}