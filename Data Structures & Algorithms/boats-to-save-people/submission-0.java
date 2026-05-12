class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int s=0,e=people.length-1, ans=0;
        while(s<=e){
            if(s==e){
                ans++;
                break;
            }
            if(people[s]+people[e]>limit){
                ans++;
                e--;
            }
            else if(people[s]+people[e]==limit){
                ans++;
                s++;
                e--;
            }
            else{
                ans++;
                s++;
                e--;
            }
        }
        return ans;
    }
}