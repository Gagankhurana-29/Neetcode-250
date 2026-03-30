class Solution {
    public int missingNumber(int[] nums) {
        int le = nums.length;
        int ts = (le*(le+1))/2;
        int cs = 0;
        for(int n : nums){
            cs += n;
        }
        return ts-cs;
    }
}
