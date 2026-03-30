class Solution {
    
    String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return ans;
        backTrack(0,"",digits);
        return ans;
    }

    public void backTrack(int i, String curr, String digits){
        if(curr.length() == digits.length()){
            ans.add(curr);
            return;
        }
          String chars = keys[digits.charAt(i) - '0'];
          for(char c : chars.toCharArray()){
            backTrack(i+1,curr + c,digits);
          }
    }

}