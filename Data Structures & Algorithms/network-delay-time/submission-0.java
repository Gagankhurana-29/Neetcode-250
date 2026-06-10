class Node{
    int nbr;
    int time;

    public Node(int nbr, int time){
        this.nbr = nbr;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Node>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            graph.get(u).add(new Node(v,t));
        }

        boolean[] visited = new boolean[n+1];

         PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.time-b.time);

        pq.offer(new Node(k,0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int curr = node.nbr;

            if(visited[curr]) continue;
            visited[curr] = true;

            for(Node nbr : graph.get(curr))
            {
                if(!visited[nbr.nbr]  && dist[curr] + nbr.time < dist[nbr.nbr]){
                    dist[nbr.nbr] = dist[curr] + nbr.time;
                    pq.offer(new Node(nbr.nbr, dist[nbr.nbr]));
                }
            }
        }

       int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
