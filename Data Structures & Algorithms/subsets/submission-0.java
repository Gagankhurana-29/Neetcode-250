class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(int[] nums,int i, List<Integer> ans){
            res.add(new ArrayList<>(ans));

        for(int j=i;j<nums.length;j++)
        {
            ans.add(nums[j]);
            backtrack(nums,j+1,ans);
            ans.remove(ans.size()-1);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        backtrack(nums,0,ans);
        return res;
    }
}
