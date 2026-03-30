class Solution {
    public boolean isHappy(int n) {
      int slow = n;
      int fast = (int)Math.pow(slow,2);
      if(slow == 1 || fast == 1) return true;
      while(slow != fast){
        slow = calculateSquare(slow);
        fast = calculateSquare(calculateSquare(fast));
         if(slow == 1 || fast == 1) return true;
      }
      return false;   
    }

    public int calculateSquare(int n){
       if (n<10) return n*n;
       int ans = 0;
       while(n!=0){
        int rem = n%10;
        ans += (int)Math.pow(rem,2);
        n /= 10;
      }
      return ans;
    }
}
