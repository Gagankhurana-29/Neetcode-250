class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isWord = false;
    }

    public void addWord(String word){
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

}

class Solution {
    Set<String> res = new HashSet<>();
     boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words)
    {

    TrieNode root = new TrieNode();
    
    for(String s : words){
        root.addWord(s);
    }

     int r = board.length;
     int c = board[0].length; 
     visited = new boolean[r][c];

     for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            dfs(board,i,j,root,"");
        }
     }
      return new ArrayList<>(res);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node,String word){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length ||
        visited[r][c] || !node.children.containsKey(board[r][c])) return;

        word += board[r][c];
        node = node.children.get(board[r][c]);
        if(node.isWord) res.add(word); 
        visited[r][c] = true;

        dfs(board,r+1,c,node,word);
        dfs(board,r,c+1,node,word);
        dfs(board,r,c-1,node,word);
        dfs(board,r-1,c,node,word);

        visited[r][c] = false;    
    }
}
