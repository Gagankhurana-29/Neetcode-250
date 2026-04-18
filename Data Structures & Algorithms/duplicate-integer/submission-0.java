class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int n : nums){
            if(hs.contains(n)) return true;
            hs.add(n);
        }
        return false;
    }
}