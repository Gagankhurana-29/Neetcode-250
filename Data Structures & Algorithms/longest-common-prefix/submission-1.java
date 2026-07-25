class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
       String shortest = strs[0];
       StringBuilder res = new StringBuilder("");
       for(int i=0;i<shortest.length();i++)
       {
          char c1 = shortest.charAt(i);
          for(String s : strs)
          {
            if(c1!=s.charAt(i)) return res.toString();
          }
          res.append(c1);
       }
       return res.toString();
    }       
}