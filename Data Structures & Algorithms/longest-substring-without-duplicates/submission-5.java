class Solution {
   public int lengthOfLongestSubstring(String s) {
      int[] chars = new int[128];
      int st=0,ans=0;
      int e = 0;
      while(e<s.length()){
        char c = s.charAt(e);
        if(chars[c]!=0){
            while(s.charAt(st) != c){
                chars[s.charAt(st)]--;
                st++;
            }
            chars[s.charAt(st)]--;
            st++;
        }
        chars[c]++;
        ans = Math.max(ans,e-st+1);
        e++;
      }
      return ans;  
    }
}
