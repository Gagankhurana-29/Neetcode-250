class DSU{
    int[] parent;
    int[] rank;

    public DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int val1, int val2){
        int pu = find(val1);
        int pv = find(val2);
        if(pu == pv) return false;
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
            rank[pv] += rank[pu];
        }
        else{
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }
        return true;
    }

}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                edges.add(new int[]{dist,i,j});
            }
        }

        edges.sort((a,b)->Integer.compare(a[0],b[0]));
        int res = 0;

        for(int[] edge : edges){
            if(dsu.union(edge[1],edge[2])){
                res += edge[0];
            }
        }

        return res;
    }
}
