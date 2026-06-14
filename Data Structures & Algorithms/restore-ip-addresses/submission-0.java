class Solution {

    Set<String> hs = new HashSet<>();

    public List<String> restoreIpAddresses(String s) {
    
    if(s.length()<4 || s.length()>12) return List.of();

    List<String> segments = new ArrayList<>();

    backTrack(s,0,segments);

    return new ArrayList<>(hs);

    }

    public void backTrack(String s, int start, List<String> segments){

        if(segments.size()==4){
            if(start==s.length()){
                hs.add(String.join(".",segments));
            }
        }

        for(int len=1; len<=3; len++){
 
            if(start+len>s.length()) break;
 
            String sub = s.substring(start,start+len);
 
            if(sub.length()>1 && sub.charAt(0)=='0') break;
 
            if(Integer.parseInt(sub)>255) break;
 
            segments.add(sub);
 
            backTrack(s,start+len,segments);
 
            segments.remove(segments.size()-1);
        }

    }
}