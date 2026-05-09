class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            graph.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        int idx = 0;
        while(!qu.isEmpty()){
            int node = qu.poll();
            ans[idx++] = node;
            for(int n : graph.get(node)){
                indegree[n]--;
                if(indegree[n]==0){
                    qu.offer(n);
                }
            }            
        }
        return idx==numCourses ? ans : new int[0];
    }
}
