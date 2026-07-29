class Solution {
    Set<List<Integer>> hs = new HashSet<>();
    public void backtrack(int[] nums,int target,int i,List<Integer> ans)
    {
        if(target==0){
            hs.add(new ArrayList<>(ans));
        }
        if(target<0) return;

        for(int j=i;j<nums.length;j++)
        {
            ans.add(nums[j]);
            backtrack(nums,target-nums[j],j,ans);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
     backtrack(nums,target,0,new ArrayList<>());
     return new ArrayList<>(hs);   
    }
}
