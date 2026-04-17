class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] freq = new int[3];
        for(int b : bills){
            if(b==5){
                freq[0]++;
            }
            else if(b==10){
                if(freq[0]>0){
                    freq[0]--;
                    freq[1]++;
                }
                else{
                    return false;
                }
            }
            else{
                if(freq[0]>0 && freq[1]>0){
                    freq[0]--;
                    freq[1]--;
                }
                else if(freq[0]>2){
                    freq[0]-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}