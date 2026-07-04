class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String s : operations)
        {
            switch(s)
            {
                case "+": {
                  int val1 = st.pop();
                  int val2 = st.pop();
                  int val3 = val1+val2;
                  st.push(val2);
                  st.push(val1);
                  st.push(val3);
                   break;
                }
                 
            
                case "D":
                    int val4 = st.pop();
                    int val5 = 2*val4;
                    st.push(val4);
                    st.push(val5);
                    break;
                
                case "C":
                    st.pop();
                    break;
                default:
                    st.push(Integer.parseInt(s));
                    break;
            }
        }
        int ans = 0;
        while(!st.isEmpty())
        {
            ans+=st.pop();
        }
        return ans;
    }
}