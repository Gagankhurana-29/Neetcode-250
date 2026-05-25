class Solution {
    public int trap(int[] height) {
        int[] lm = new int[height.length];
        int[] rm = new int[height.length];
        lm[0]=height[0];
        rm[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            if(height[i]>lm[i-1]){
                lm[i]=height[i];
            }
            else{
                lm[i] = lm[i-1];
            }
        }
           for(int i=height.length-2;i>=0;i--){
            if(height[i]>rm[i+1]){
                rm[i]=height[i];
            }
            else{
                rm[i] = rm[i+1];
            }
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            res+= Math.min(lm[i],rm[i])-height[i];
        }
        return res;
    }
}
