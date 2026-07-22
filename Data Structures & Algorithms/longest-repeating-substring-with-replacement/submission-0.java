class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> hm = new HashMap<>();
        int n= s.length();
        int l=0;
        int omax = 0;
        int maxf=0;
        for(int r=0;r<n;r++)
        {
            char c = s.charAt(r);
            hm.put(c,hm.getOrDefault(c,0)+1);
            maxf = Math.max(maxf,hm.get(c));
            while((r-l+1) - maxf > k)
            {
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l++;
            }
            omax = Math.max(omax,r-l+1);
        }
        return omax;
    }
}
