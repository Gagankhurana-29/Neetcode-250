class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->b.getValue() - a.getValue());
            pq.addAll(hm.entrySet());
        int[] ans = new int[k];
        int temp=0;
        while(k>0){
            Map.Entry<Integer,Integer> entry = pq.poll();
            ans[temp] = entry.getKey();
            temp++; 
            k--;
        }
        return ans;
    }
}
