class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start=0,end=0;
        for(int i=start;i<s.length();i++){
            end = Math.max(end,lastIndex[s.charAt(i)-'a']);
            if(i==end){
                ans.add(end-start+1);
                 start = end+1;
            }
        }
        return ans;
    }
}
