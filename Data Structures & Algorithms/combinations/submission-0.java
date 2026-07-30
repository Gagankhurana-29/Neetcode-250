class Solution {

    Set<List<Integer>> hs = new HashSet<>();

    public void backtrack(int[] nums,int i,List<Integer> ans,int k)
    {
        if(ans.size()==k)
        {
            hs.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<nums.length;j++)
        {
            ans.add(nums[j]);
            backtrack(nums,j+1,ans,k);
            ans.remove(ans.size()-1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = i+1;
        }

        List<Integer> ans = new ArrayList<>();
        backtrack(nums,0,ans,k);
        return new ArrayList<>(hs);
    }
}