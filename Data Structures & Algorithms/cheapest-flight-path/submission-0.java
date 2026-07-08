class Edge{
    int dest;
    int cost;

    public Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}

class Pair{
    Edge e;
    int val;
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Edge>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] flight : flights)
        {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            graph.get(u).add(new Edge(v,cost));
        }

         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if (node == dst) {
                return cost;              // first time we pop dst, it's the cheapest valid path
            }
            if (stops > k) {
                continue;                 // used too many stops on this path, abandon it
            }

            for (Edge e : graph.get(node)) {
                pq.offer(new int[]{cost + e.cost, e.dest, stops + 1});
            }
        }

        return -1; // dst unreachable within k stops
}
}
