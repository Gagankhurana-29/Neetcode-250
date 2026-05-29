class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        
        int n = numCourses;
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            graph.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0; i<indegree.length;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        if(qu.isEmpty()) return false;
        while(!qu.isEmpty()){
            int num = qu.poll();
            for(int nbr : graph.get(num)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    qu.offer(nbr);
                }
            }
        }
        for(int i : indegree){
            if(i>0) return false;
        }
        return true;
    }
}
