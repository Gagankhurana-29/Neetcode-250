class Solution {
    public int missingNumber(int[] nums) {
        int totalLength = nums.length;
        int le = totalLength;
        int ts = (le*(le+1))/2;
        int cs = 0;
        for(int n : nums){
            cs += n;
        }
        return ts-cs;
    }
}
