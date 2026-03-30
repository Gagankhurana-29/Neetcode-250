class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        List<Integer> sizes = new ArrayList<>();

        for(String str : strs){
            sizes.add(str.length());
        }
        StringBuilder sb = new StringBuilder();
        for(int s : sizes){
            sb.append(s);
            sb.append(",");
        }
        sb.append("@");
        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<Integer> sizes = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (str.length() == 0) return ans;
        int i=0;
        while(str.charAt(i)!='@'){
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i) != ','){
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        for(int sz : sizes){
            ans.add(str.substring(i,i+sz));
            i+=sz;
        }
        return ans;
    }
}
