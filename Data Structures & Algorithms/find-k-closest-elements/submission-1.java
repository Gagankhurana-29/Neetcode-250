class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if(k==n){
            return Arrays.stream(arr).
            boxed()
            .collect(Collectors.toList());
        }
        int l = 0;
        int h = n-1;
        List<Integer> ans = new ArrayList<>();
        while(l<h){
            if((h-l+1) == k){
                break;
            }
            if(Math.abs(arr[l]-x) > Math.abs(arr[h]-x)){
                l++;
            }
            else{
                h--;
            }
        }
        for(int i=l;i<=h;i++){
                    ans.add(arr[i]);
                }
                return ans;
    }
}