class Solution {
    public String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        if(t.length()>s.length() || t.isEmpty()) return "";
        
        Map<Character,Integer> tm = new HashMap<>();
        Map<Character, Integer> sm = new HashMap<>();
        
        for(char c : t.toCharArray()){
            tm.put(c,tm.getOrDefault(c,0)+1);
        }
        
        int resLen = Integer.MAX_VALUE;
        int l=0;
        int have=0, need=tm.size();
        int[] res = new int[2];
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            sm.put(c,sm.getOrDefault(c,0)+1);
            
            if(tm.containsKey(c) && sm.get(c).equals(tm.get(c))){
                have++;
            }

            while(have==need){
                if((r-l)+1 < resLen){
                res[0] = l;
                res[1] = r;
                resLen = (r-l)+1;
                }
                char lm = s.charAt(l);
                sm.put(lm,sm.get(lm)-1);
                if(tm.containsKey(lm) && sm.get(lm)<tm.get(lm)){
                    have--;
                }
                l++;
            }
        } 
        return resLen == Integer.MAX_VALUE ? "":s.substring(res[0],res[1]+1);
    }
}
