class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> visit = new HashSet<>(Arrays.asList(deadends));

        if(visit.contains("0000")) return -1;

        Queue<String> qu = new LinkedList<>();

        qu.offer("0000");

        int count = 0;

        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
            String curr = qu.poll();
            visit.add(curr);
            if(curr.equals(target)) return count;
            for(String next : children(curr)){
                if(!visit.contains(next)){
                    visit.add(next);
                    qu.offer(next);
                }            
             }
            }
            count++;
        }
        return -1;
    }

    public List<String> children(String curr){
        
        List<String> res = new ArrayList<>();
        
        for(int i=0;i<4;i++){
            char[] arr = curr.toCharArray();
            arr[i] = (char)(((arr[i]-'0' + 1 + 10)%10) + '0');
            res.add(new String(arr));

            arr = curr.toCharArray();
            arr[i] = (char)(((arr[i]-'0' - 1 +10)%10) + '0');
            res.add(new String(arr));
        }
        return res;
    }

}