class Solution {
    public boolean isPali(String s, int l, int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
       int st = 0, e = s.length()-1;
       while(st<e)
       {
        if(s.charAt(st)!=s.charAt(e))
        {
            return isPali(s,st+1,e) || isPali(s,st,e-1);
        }
        st++;
        e--;
       }
        return true;
    }
}