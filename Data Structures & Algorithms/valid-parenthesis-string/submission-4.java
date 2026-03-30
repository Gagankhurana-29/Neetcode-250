class Solution {
    public boolean checkValidString(String s) {
        int count = 0;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') left.push(i);
            else if(c=='*') star.push(i);
            else{
                                if (left.isEmpty() && star.isEmpty()) return false;
                 if(!left.isEmpty()){
                    left.pop();
                 }
                 else{
                    if(!star.isEmpty()){
                        star.pop();
                    }
                 }          
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            if(left.peek()>star.peek()) return false;
            left.pop();
            star.pop();
        }
        return left.size()==0;
    }
}
