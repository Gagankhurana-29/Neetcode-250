class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Arrays.stream(weights).max().getAsInt();
        int l = max, h = Arrays.stream(weights).sum();
        int ans = h;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(canShip(weights,mid,days)){
                 ans = Math.min(ans,mid);
                 h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }

    public boolean canShip(int[] weights, int mid, int d){
        int currCap = mid, ships=1;
        for(int w : weights){
            if(w>mid) return false;
            if(currCap-w<0){
                ships++;
                if(ships>d) return false;
                currCap = mid;
            }
            currCap -= w;
        }
        return true;
    }
}