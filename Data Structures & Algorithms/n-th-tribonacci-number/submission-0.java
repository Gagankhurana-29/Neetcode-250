class Solution {
    public int tribonacci(int n) {
       int t0=0,t1=1,t2=1;
       if(n==0) return t0;
       else if(n==1 || n==2) return t1;
       else{
        int t3 = 0;
        for(int i=3;i<=n;i++){
            t3 = t0+t1+t2;
            t0 = t1;
            t1=t2;
            t2=t3;
        }
        return t3;
       } 
    }
}