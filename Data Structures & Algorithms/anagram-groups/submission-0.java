class Solution {
    
    public boolean isAnangram(String s1, String s2)
    {
        if(s1.length() != s2.length()) return false;
        int[] freq = new int[26];

        for(int i=0;i<s1.length();i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            freq[c1-'a']++;
            freq[c2-'a']--;
        }

       for(int i : freq)
       {
        if(i>0) return false;
       }
       return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            List<String> ans = new ArrayList<>();
            ans.add(strs[i]);
            for(int j=i+1;j<strs.length;j++)
              {
                 if(visited[j]==false && isAnangram(strs[i],strs[j]))
                 {
                    visited[j]=true;
                    ans.add(strs[j]);
                 }
              }
              res.add(ans);
        }
        return res;
    }
}
