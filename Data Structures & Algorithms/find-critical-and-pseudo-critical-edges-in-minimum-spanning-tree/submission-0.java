class DSU{
    int[] parent;
    int[] rank;

    public DSU(int n)
    {
         parent = new int[n];
         rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findParent(int n)
    {
        if(parent[n] != n)
        {
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }

    public boolean union(int u, int v)
    {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return false;

        if(rank[pu]>rank[pv])
        {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }
        else{
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        return true;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        List<int[]> edgeList = new ArrayList<>();
        int i=0;
        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            int[] currEdge = {src,dest,cost,i++};
            edgeList.add(currEdge);
        }
        edgeList.sort(Comparator.comparingInt(a->a[2]));

        int mstWeight = 0;
        for(int[] edge : edgeList)
        {
            if(dsu.union(edge[0],edge[1]))
            {
                mstWeight += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> psuedoCritical = new ArrayList<>();

        for(int[] edge : edgeList){

            DSU dsuWithout = new DSU(n);
            int wt = 0;
            for(int[] other : edgeList)
            {
                if(other[3] != edge[3] && dsuWithout.union(other[0],other[1]))
                {
                    wt += other[2];
                }
            }

            if(Arrays.stream(dsuWithout.rank).max().getAsInt() != n ||
             wt > mstWeight)
            {
                critical.add(edge[3]);
                continue;
            }

            DSU dsuWith = new DSU(n);
            dsuWith.union(edge[0],edge[1]);
            wt = 0;
            wt += edge[2];
            for(int[] other : edgeList){
                if(dsuWith.union(other[0],other[1]))
                {
                    wt += other[2];
                }
            }
            if(wt == mstWeight)
            {
                psuedoCritical.add(edge[3]);
            }
        }
        return Arrays.asList(critical,psuedoCritical);
    }
}