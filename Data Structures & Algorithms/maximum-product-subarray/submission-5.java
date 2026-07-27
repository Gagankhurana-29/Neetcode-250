class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1;
        int minProd = 1;
        int res = nums[0];
        for(int n : nums)
        {
            if(n < 0)
            {
                int temp = minProd;
                minProd = maxProd;
                maxProd = temp;
            }
            maxProd = Math.max(n,n * maxProd);
            minProd = Math.min(n,n * minProd);
            res = Math.max(res,maxProd);
        }
        return res;
     }
}
