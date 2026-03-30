class Solution {

    public void backtrack(int oc, int cc,List<String> res, int n, StringBuilder ans){
        if(oc == cc && oc == n){
            res.add(ans.toString());
            return;
        }
        if(oc < n){
            ans.append('(');
            backtrack(oc+1,cc,res,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
        if(cc < oc){
            ans.append(')');
            backtrack(oc,cc+1,res,n,ans);
            ans.deleteCharAt(ans.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder("");
        backtrack(0,0,res,n,ans);
        return res;
    }
}
