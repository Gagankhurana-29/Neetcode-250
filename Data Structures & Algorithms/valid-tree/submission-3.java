class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) return false;
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] a : edges){
            int u = a[0];
            int v = a[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        
        // check the cycle
        if(isCyclic(graph,0,visited,-1)) return false;

        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
        
        return true;

    }

    public boolean isCyclic(List<List<Integer>> graph, int src, boolean[] visited,int parent){
        visited[src] = true;
        for(int nbr:graph.get(src)){
            if(!visited[nbr]){
                if(isCyclic(graph,nbr,visited,src)) return true;
            }
            else{
                 if(nbr != parent) return true;
            }
        }
        return false;
    }
}
