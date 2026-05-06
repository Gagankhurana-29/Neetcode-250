class Solution {
    public int subsetXORSum(int[] nums) {
    int n = nums.length;
    int xsum = 0;
    for(int i=0; i<((1<<n)); i++){
        int cx=0;
        for(int j=0;j<n;j++){
            if((i & (1<<j)) != 0){
                if(cx ==0){
                    cx = nums[j];
                }
                else{
                    cx = cx ^ nums[j];
                }
            }
        }
           xsum += cx;
    }    
        return xsum;
    }
}
