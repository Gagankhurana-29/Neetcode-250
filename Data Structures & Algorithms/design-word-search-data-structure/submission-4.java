class WordDictionary {

    class Node{
        char val;
        Node[] children;
        boolean isWord;

        public Node(char val){
            this.val = val;
            children = new Node[26];
            isWord = false;
        }
    }

    class Trie{
        Node[] keys;
        public Trie(){
            keys = new Node[26];
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Node[] dict = trie.keys;
        int i=0;
       for(char c: word.toCharArray()){
            Node n = dict[c-'a'];
            if(n != null) {
                dict = n.children;
            }
            else{
            Node node = new Node(c);
            dict[c-'a'] = node;
            n = node; 
            dict = n.children;
            }
            if(i==word.length()-1){
                n.isWord = true;
            }
            i++;
       }

    }

    public boolean search(String word) {
       return searchHelper(0,word,trie.keys);
    }

    public boolean searchHelper(int i, String word, Node[] dict){
        if(i==word.length()){
            return false;
        }

        boolean isLastIndex = (i==word.length()-1);

        if(word.charAt(i)=='.'){
            for(Node node : dict){
                if(node != null){
                    if(isLastIndex && node.isWord) return true;
                    if(searchHelper(i+1,word,node.children)){
                        return true;
                    }
                }
            }
            return false;
        }
        else{
            Node node = dict[word.charAt(i)-'a'];
            if(node == null) return false;
            if(isLastIndex && node.isWord) return true;
            return searchHelper(i+1,word,node.children);
        }
    }
}
