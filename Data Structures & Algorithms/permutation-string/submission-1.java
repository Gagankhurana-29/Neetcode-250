class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length()) return false;
        
        int n1 = s1.length();
        int n2 = s2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(char c : s1.toCharArray())
        {
            freq1[c-'a']++;
        }

        for(int i=0;i<n2;i++)
        {
            char c = s2.charAt(i);
            if(freq1[c-'a']!=0)
            {
                int j=i;
                for(;j<n2 && j<i+n1;j++)
                {
                    char p = s2.charAt(j);
                    if(freq1[p-'a']==0) break;
                    freq2[p-'a']++;
                }
                if(Arrays.equals(freq1,freq2)) return true;
                else {
                    Arrays.fill(freq2,0);
                //    i=j;
                }
            }
        }
        return false;
    }
}
