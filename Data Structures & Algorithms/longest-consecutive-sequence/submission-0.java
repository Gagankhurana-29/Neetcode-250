class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i:nums)
        {
            if(!hm.containsKey(i)){
                hm.put(i,hm.getOrDefault(i-1,0)+hm.getOrDefault(i+1,0)+1);
                hm.put(i-hm.getOrDefault(i-1,0),hm.get(i));
                hm.put(i+hm.getOrDefault(i+1,0),hm.get(i));
                ans = Math.max(ans,hm.get(i));
            }
        }
        return ans;
    }
}
