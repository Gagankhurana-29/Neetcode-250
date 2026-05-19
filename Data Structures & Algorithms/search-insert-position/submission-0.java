class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m]<target){
                l=m+1;
            }
            else{
                h=m-1;
            }
        }
        return l;
    }
}