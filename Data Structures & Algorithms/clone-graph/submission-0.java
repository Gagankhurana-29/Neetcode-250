/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
          if (node == null) return null;
        Queue<Node> qu = new LinkedList<>();
        Map<Node,Node> hm = new HashMap<>();
        Node clone = new Node(node.val);
        hm.put(node,clone);
        qu.offer(node);
        while(!qu.isEmpty()){
            Node n = qu.poll();
            for(Node nbr : n.neighbors){
                if(!hm.containsKey(nbr)){
                    Node newNode = new Node(nbr.val);
                    hm.put(nbr,newNode);
                    qu.offer(nbr);
                }
                hm.get(n).neighbors.add(hm.get(nbr));
            }  
        }
            return clone;
    }
}