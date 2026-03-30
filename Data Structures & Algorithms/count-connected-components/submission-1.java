class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        //initialize the graph 
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(graph,i,visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> graph, int src, boolean[] visited){
        if(visited[src]) return ;
        visited[src] = true;
        for(int nbr: graph.get(src)){
            if(visited[nbr]==false){
                dfs(graph,nbr,visited);
            }
        }
    }
}
