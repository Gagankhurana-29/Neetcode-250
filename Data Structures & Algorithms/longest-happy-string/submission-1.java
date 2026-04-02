class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((d,e)->e[0]-d[0]);
        if(a>0) pq.offer(new int[]{a, 0});
        if(b>0) pq.offer(new int[]{b, 1});
        if(c>0) pq.offer(new int[]{c, 2});
        StringBuilder ans = new StringBuilder("");
        while(!pq.isEmpty())
        {
          int[] val = pq.poll();
          char ch = (char)(val[1]+97);
          int n = ans.length();
          if(n > 1 && ans.charAt(n-1) == ch && ans.charAt(n-2)==ch){
            if(pq.isEmpty()) break;
                int[] second = pq.poll();
                ans.append((char)(second[1]+97));
                second[0]--;
                if(second[0]>0){
                    pq.offer(second);
                }
                pq.offer(val);   
          }
          else{
            ans.append(ch);
            val[0]--;
            if(val[0]>0){
                pq.offer(val);
            }
          }   
        }
        return ans.toString();
    }
}