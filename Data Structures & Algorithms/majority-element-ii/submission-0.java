class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int minFreq = nums.length/3;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> al = new ArrayList<>();
        for(int n : nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }
        for(int k : freqMap.keySet()){
            if(freqMap.get(k)>minFreq){
                al.add(k);
            }
        }
        return al;
    }
}