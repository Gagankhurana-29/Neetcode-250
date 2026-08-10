class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n==0) return;

        int[] nums3 = new int[m+n];
        int first = 0, second = 0;
        int k=0;
        while(first<m && second<n)
        {
            if(nums1[first]<nums2[second])
            {
                nums3[k] = nums1[first];
                first++;
            }
            else{
                nums3[k] = nums2[second];
                second++;
            }
            k++;
        }
        while(first<m)
        {
            nums3[k] = nums1[first];
            first++;
            k++;
        }
        while(second<n){
            nums3[k] = nums2[second];
            second++;
            k++;
        }
        
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }

    }
}