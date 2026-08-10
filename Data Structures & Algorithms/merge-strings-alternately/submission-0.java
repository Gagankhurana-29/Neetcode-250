class Solution {
    public String mergeAlternately(String word1, String word2) {
     int firstStringWordLength = 0;
     int secondStringWordLength = 0;
     StringBuilder sb = new StringBuilder("");
     while(firstStringWordLength<word1.length() && secondStringWordLength<word2.length()){
         sb.append(word1.charAt(firstStringWordLength));
         sb.append(word2.charAt(secondStringWordLength));
         firstStringWordLength++;
         secondStringWordLength++;
     }
     if(firstStringWordLength<word1.length()){
         String str = word1.substring(firstStringWordLength);
         sb.append(str);
     }
     if(secondStringWordLength<word2.length()){
         String str = word2.substring(secondStringWordLength);
         sb.append(str);
     }
     return sb.toString();

    }
}