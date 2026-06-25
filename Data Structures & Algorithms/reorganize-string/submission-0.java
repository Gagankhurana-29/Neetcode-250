class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray())
        {
            freq[c-'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.offer(new int[]{freq[i],i});
            }
        }
        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while(!pq.isEmpty() || prev != null )
        {
            if(prev != null && pq.isEmpty()){
                return "";
            }

            int[] curr = pq.poll();
            res.append((char)(curr[1]+'a'));
            curr[0]--;

            if(prev != null){
                pq.offer(prev);
                prev=null;
            }

            if(curr[0]>0){
                prev=curr;
            }

        }

        return res.toString();
    }
}
// aaaabcdefg

// a-4,2-1,3-1,4-1,5-1,6-1,7-1
// a 3 prev=a
// b
// a prev = a
