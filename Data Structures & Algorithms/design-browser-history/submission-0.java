class Node{
    String url;
    Node next;
    Node prev;

    public Node(String url){
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}


class BrowserHistory {

    Node head;
    Node curr;

    public BrowserHistory(String homepage) {
        head = new Node("start");
        curr = new Node(homepage);
        head.next = curr;
        curr.prev = head;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        curr = node;
    }
    
    public String back(int steps) {
        while(curr.prev!=head && steps>0){
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps>0 && curr.next!=null){
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */