class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int ans = high;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(canEat(piles,mid,h)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean canEat(int[] piles, int ch, int h){
        long count = 0;
        for(int p : piles){
            count += p/ch;
           if(p%ch != 0) count++; 
        }
        return count<=h ? true : false;
    }
}
