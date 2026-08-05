class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
     
     int[][] cars = new int[position.length][2];

     for(int i=0;i<position.length;i++){
        int pos = position[i];
        int sp = speed[i];
        cars[i][0] = pos;
        cars[i][1] = sp;
     }

     Arrays.sort(cars,(a,b) -> b[0]-a[0]);
     Stack<Double> st = new Stack<>();

    for(int[] car : cars){
        double tt = (double)(target-car[0])/car[1];
        if(st.isEmpty() || st.peek()<tt){
            st.push(tt);
        }
    }
        return st.size();
    }
}