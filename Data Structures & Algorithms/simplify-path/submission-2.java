//import java.util.Deque;
class Solution {
    public String simplifyPath(String path) {
        Deque<String> deq = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String s : parts){
            if(s.isEmpty() || s.equals(".")){
                continue;        
            }
            else if(s.equals("..")){
               if (!deq.isEmpty()) deq.removeLast();
            }
            else{
                deq.addLast(s);
            }
        }
        
        if(deq.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder("");
        while(!deq.isEmpty()){
            sb.append('/');
            sb.append(deq.removeFirst());
        }
        return sb.toString();

    }
}