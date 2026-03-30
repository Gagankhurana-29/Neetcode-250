class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder("");
           while(columnNumber > 0){
            columnNumber--;
            int div = columnNumber/26;
            int rem = columnNumber % 26;
            char d = (char)('A' + rem);
            sb.insert(0,d);
            columnNumber = div;
        }
        return sb.toString();
    }
}