class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        Boolean[][] visited = new Boolean[numCourses][numCourses];

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            int u = pre[0];
            int v = pre[1];
            graph.get(u).add(v);
        }

        List<Boolean> res = new ArrayList<>();
        
        for(int[] query : queries){
            boolean ans = dfs(graph,query[0],query[1],visited);
            res.add(ans);
        }

        return res;
    }

    public boolean dfs(List<List<Integer>> graph, int src, int dest, Boolean[][] visited){
        if(visited[src][dest]!= null) return visited[src][dest];
        if(src==dest){
            visited[src][dest] = true;
            return true;
        }
        for(int nbr : graph.get(src)){
            boolean a = dfs(graph,nbr,dest,visited);
            if(a){
                visited[src][dest] = true;
                return true;
            }
        }
        visited[src][dest] = false;
        return false;
    }

}