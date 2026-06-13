class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> hm = new HashMap<>();
        int l=0,total=0,res=0;
        for(int r=0;r<fruits.length;r++){
             hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);
             total++;
             while(hm.size()>2){
                int fl = fruits[l];
                hm.put(fl,hm.get(fl)-1);
                total--;
                if(hm.get(fl)==0){
                    hm.remove(fl);
                }
                l++;
             }
             res = Math.max(total,res);
        }
        return res;
    }
}