class Solution {
    
    Set<List<String>> hs = new HashSet<>();
    
    public void backTrack(String s, int i,List<String> ans)
    {
        if(i==s.length())
        {
             hs.add(new ArrayList<>(ans));
             return;
        }

        for(int j=i;j<s.length();j++)
        {
            if(isPali(s,i,j))
            {
                ans.add(s.substring(i,j+1));
                backTrack(s,j+1,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public boolean isPali(String s,int i, int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        backTrack(s,0,ans);
        return new ArrayList<>(hs);    
    }
}
