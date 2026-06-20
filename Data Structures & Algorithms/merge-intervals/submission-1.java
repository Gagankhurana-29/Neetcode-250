class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> res =  new ArrayList<>();
        for(int[] a : intervals){
            List<Integer> minor = new ArrayList<>();
            minor.add(a[0]);
            minor.add(a[1]);
            res.add(minor);
        }
        int i=0;
        while(i<res.size()-1)
        {
            List<Integer> first = res.get(i);
            List<Integer> second = res.get(i+1);
            if(first.get(1)>=second.get(0))
            {
                int min = Math.min(first.get(0),second.get(0));
                int max = Math.max(first.get(1),second.get(1));
                res.remove(i+1);
                res.remove(i);
                List<Integer> newList = new ArrayList<>();
                newList.add(min);
                newList.add(max);
                res.add(i,newList);
            }
            else{
                i++;
            }
        }
        int[][] ans = new int[res.size()][2];
         i = 0;
        for(List<Integer> ls : res){
            ans[i][0] = ls.get(0).intValue();
            ans[i][1] = ls.get(1).intValue();
            i++;
        }
        return ans;
    }
}
