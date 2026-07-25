class Solution {

    public String encode(List<String> strs) {
       StringBuilder res = new StringBuilder("");
       int sIndex=0;
       for(String s : strs)
       {
        int slength = s.length();
         res.append(slength);
         res.append("#");
         res.append(s);
       }
       return res.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i<str.length())
        {
           int j = i;
           while(str.charAt(j)!='#')
           {
            j++;
           }
           int len = Integer.parseInt(str.substring(i,j));
           String s = str.substring(j+1,j+1+len);
           ans.add(s);
           i=j+1+len;
        }
        return ans;
    }
}
