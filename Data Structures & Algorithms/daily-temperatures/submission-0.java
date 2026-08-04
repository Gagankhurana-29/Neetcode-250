class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        //Stack of value and index
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{temperatures[0],0});
        for(int i=1;i<temperatures.length;i++)
        {
            int newTemp = temperatures[i];
            while(!st.isEmpty() && st.peek()[0]<newTemp)
            {
                int[] curr = st.pop();
                int idx = curr[1];
                result[idx] = i-idx;
            }
            st.push(new int[]{newTemp,i});
        }
        while(!st.isEmpty())
        {
            int[] last = st.pop();
            int idx = last[1];
            result[idx] = 0;
        }
        return result;
    }
}
