 public class TreeNode{
        char val;
        Map<Character,TreeNode> children;
        boolean isWord;

        public TreeNode(){
            children = new HashMap<>();
            isWord = false;
        }

        public TreeNode(char c){
            this.val = c;
            children = new HashMap<>();
            isWord = false;
        }
 }

class PrefixTree {

    private TreeNode root;

    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
            TreeNode node = root;
            for(char c : word.toCharArray()){
                   node.children.putIfAbsent(c, new TreeNode());
                   node = node.children.get(c); 
                }
                node.isWord = true;
            }

    public boolean search(String word) {
         TreeNode node = root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(char c : prefix.toCharArray())
        {
            if(!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }
}
