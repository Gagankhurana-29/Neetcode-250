class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(int[] nums,boolean[] visited,List<Integer> ans){
        if(ans.size()==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int j=0;j<nums.length;j++)
        {
            if(visited[j]) continue;
            visited[j] = true;
            ans.add(nums[j]);
            backtrack(nums,visited,ans);
            visited[j] = false;
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new boolean[nums.length],new ArrayList<>());
        return res;
    }
}
