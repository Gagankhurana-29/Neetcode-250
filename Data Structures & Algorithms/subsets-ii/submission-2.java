class Solution {

    private Set<List<Integer>> allSub = new HashSet<>();
    private List<List<Integer>> allOnBits = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<Integer> sub = new ArrayList<>();
        backTrack2(nums,nums.length);
        return new ArrayList<>(allSub);
    }

    public void backTrack(int[] nums, int n, List<Integer> sub, int i){
        if(i==n){
            allSub.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        backTrack(nums,n,sub,i+1);
        sub.remove(sub.size()-1);
        backTrack(nums,n,sub,i+1);
    }

    public void backTrack2(int[] nums, int n){
        for(int i=0;i<(1<<n);i++){
            List<Integer> sub = new ArrayList<>();
            List<Integer> onBits = new ArrayList<>();

            for(int j=0;j<n;j++)
            {
                if((i & (1<<j)) != 0){

                    sub.add(nums[j]);
                    onBits.add(nums[j]);
                }
            }
            Collections.sort(onBits);
             if(!allOnBits.contains(onBits))
             {
                    allSub.add(sub);
                    allOnBits.add(onBits);
             }
        }
    }
}
