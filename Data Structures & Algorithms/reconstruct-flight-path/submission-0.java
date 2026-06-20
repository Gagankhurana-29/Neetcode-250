class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
       Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for(List<String> ticket : tickets)
		{
			graph.computeIfAbsent(ticket.get(0),k -> new PriorityQueue<String>())
            .offer(ticket.get(1));
}
List<String> ans = new ArrayList<>();
dfs(graph,"JFK",ans);
Collections.reverse(ans);
    return ans;
    }
	
	public void dfs(Map<String,PriorityQueue<String>> graph, String src, List<String> ans)
{
	PriorityQueue<String> qu = graph.get(src);
	while(qu != null && !qu.isEmpty())
{
	String dest = qu.poll();
	dfs(graph,dest,ans);
}
ans.add(src);
}
}



