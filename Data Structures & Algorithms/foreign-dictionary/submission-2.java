class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,Integer> inDegree = new HashMap<>();
      Map<Character,HashSet<Character>> graph = new HashMap<>();
      for(String str : words){
        for(char c : str.toCharArray()){
            inDegree.put(c,0);
        }
      }
      for(int i=0;i<words.length-1;i++){
        String curr = words[i];
        String next = words[i+1];
        boolean flag = false;
        int minLen = Math.min(curr.length(),next.length());
        for(int j=0;j<minLen;j++){
             char c1 = curr.charAt(j);
             char c2 = next.charAt(j);
            if(c1 != c2){ 
                flag = true; 
                graph.putIfAbsent(c1, new HashSet<>());
                 if(graph.get(c1).add(c2)) 
                 { 
                    inDegree.put(c2, inDegree.get(c2)+1);
                } 
                break;
                }
        }
        if(!flag && next.length()<curr.length()) return "";
      }

      Queue<Character> qu = new LinkedList<>();
      for(Character c : inDegree.keySet()){
        if(inDegree.get(c) == 0){
            qu.offer(c);
        }
      }

        StringBuilder sb = new StringBuilder("");

        while(!qu.isEmpty()){
            char c = qu.poll();
            sb.append(c);
            if(graph.containsKey(c)){
            HashSet<Character> hs = graph.get(c);
            for(char c1 : hs){
                inDegree.put(c1,inDegree.get(c1)-1);
                if(inDegree.get(c1)==0){
                    qu.offer(c1);
                }
            }
            }
        }
        if(sb.length() != inDegree.size()) return "";
        return sb.toString();
    }
}
