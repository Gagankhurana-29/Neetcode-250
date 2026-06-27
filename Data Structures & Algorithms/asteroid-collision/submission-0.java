class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> st = new Stack<>();
        for(int a : asteroids)
        {
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && a<0)
            {
                if(Math.abs(st.peek()) == Math.abs(a))
                {
                    st.pop();
                    destroyed = true;
                    break;
                }
                else if(Math.abs(st.peek()) > Math.abs(a))
                {
                    destroyed = true;
                    break;
                }
                else{
                    st.pop();
                }
            }
            if(!destroyed) st.push(a);
        }

        int size = st.size();
        int[] ans = new int[size];
        while(!st.isEmpty())
        {
            int val = st.pop();
            ans[--size] = val;
        }
        return ans;
    }
}