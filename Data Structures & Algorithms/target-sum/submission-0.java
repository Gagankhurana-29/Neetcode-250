class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
         Map<Integer,Integer> hm1;
         hm.put(0,1);
        for(int n : nums)
        {
           hm1 = new HashMap<>();
            for(int key : hm.keySet())
            {
                int count = hm.get(key);
                int pos = key + n;
                int neg = key - n;
                hm1.put(pos,hm1.getOrDefault(pos,0)+count);
                hm1.put(neg,hm1.getOrDefault(neg,0)+count);
            }
            hm = new HashMap<>(hm1);
        }
        return hm.getOrDefault(target,0);
    }
}
