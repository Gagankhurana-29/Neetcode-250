class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     int start=0, end=0;
     int cs=0, ans = Integer.MAX_VALUE;
      while(end<nums.length){
        cs += nums[end];
         while(cs >= target){
            ans = Math.min(ans,end-start+1);
            cs -= nums[start];
            start++;
         }
         end++;
      }
      return end-start==nums.length?0:ans;   
    }
}