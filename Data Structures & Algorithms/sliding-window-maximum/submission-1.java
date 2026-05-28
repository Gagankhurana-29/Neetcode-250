class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         List<Integer> al = new ArrayList<>();
         Deque<Integer> qu = new ArrayDeque<>();
         int idx = 0;
         while(idx<nums.length){
            while(!qu.isEmpty() && nums[idx]>qu.getLast()){
                qu.pollLast();
            }
            qu.offer(nums[idx]);
            if(idx>=k && qu.getFirst() == nums[idx-k]){
                qu.pollFirst();
            }
            if(idx >= k-1){
                al.add(qu.getFirst());
            }
            idx++;
         }
         return al.stream().mapToInt(i->i).toArray();     
    }
}
