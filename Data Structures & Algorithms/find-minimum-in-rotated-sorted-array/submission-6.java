class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int l=0, h=nums.length-1;
        while(l<=h){
            if(nums[l]<=nums[h]) return nums[l];
            int m = l + (h-l)/2;
            if(nums[m]>nums[h]){
                l = m+1;
            }
            else{
                h = m;
            }
        }
        return -1;
    }
}
