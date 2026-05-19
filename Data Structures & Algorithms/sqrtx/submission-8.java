class Solution {
    public int mySqrt(int x) {
        if (x==1) return x;
        int l=0, h=x;
        while(l<=h){
            int m = l + (h-l)/2;     //13/2 = 6
            long sq = (long) m*m;
            if(sq==x) return m;
            else if(sq > x){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return h;
    }
}