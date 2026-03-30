class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] nums, int l,int r){
        if(l >= r) return;
        int m = (l+r) >> 1;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums , l, m , r);
    }

    public void merge(int[] nums, int l, int m, int r){
        int i = l, j = m+1;
        List<Integer> al = new ArrayList<>();
        while(i<=m && j<=r){
            if(nums[i]<=nums[j]){
                al.add(nums[i]);
                i++;
            }
            else{
                al.add(nums[j]);
                j++;
            }
        }

        while(i<=m){
            al.add(nums[i]);
            i++;
        }
        while(j<=r){
            al.add(nums[j]);
            j++;
        }

        for(i=l;i<=r;i++){
            nums[i]=al.get(i-l);
        }
    }

}

