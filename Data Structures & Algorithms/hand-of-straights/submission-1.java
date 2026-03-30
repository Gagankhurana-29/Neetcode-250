class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i : hand){
            hm.put(i,hm.getOrDefault(i,0)+1);
            min = Math.min(min,i);
        }
        while(!hm.isEmpty()){
            int temp = Integer.MAX_VALUE;
            for(int k : hm.keySet()){
                temp = Math.min(temp,k);
            }
            for(int i=temp;i<temp+groupSize;i++){
                if(!hm.containsKey(i)) return false;
                if(hm.get(i) == 1){
                    hm.remove(i);
                }
                else{
                    hm.put(i,hm.get(i)-1);
                }
            }
        }
        return true;
    }
}
