class Solution {
    Set<List<Integer>> hs = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        backtrack(nums,ans,new boolean[nums.length]);
        return new ArrayList<>(hs);
    }

    public void backtrack(int[] nums, List<Integer> ans, boolean[] visited)
    {
        if(ans.size()==nums.length){
            hs.add(new ArrayList<>(ans));
            return;
        }

        for(int j=0;j<nums.length;j++)
        {
            if(visited[j]) continue;
            visited[j] = true;
            ans.add(nums[j]);
            backtrack(nums,ans,visited);
            ans.remove(ans.size()-1);
            visited[j]=false;
        }

    }

}