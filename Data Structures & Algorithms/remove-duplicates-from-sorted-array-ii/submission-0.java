class Solution {
    public int removeDuplicates(int[] nums) {
        int start=0;
        int end = 0;
        int temp = 0;
        for(int i=start;i<nums.length;i++){
            if(nums[i]==nums[start]){
                end++;
            }
            else{
                start=end;
                end++;
            }
            if(end-start<=2){
                nums[temp] = nums[start];
                temp++;
            }
        }
        return temp;
    }
}