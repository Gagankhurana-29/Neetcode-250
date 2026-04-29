// ALIEN DICTIONARY VERIFICATION

class Solution {
    public boolean isAlienSorted(String[] words, String order)            {
	int[] pos = new int[26];
for(int i=0; i<order.length(); i++)
  {
  	char c = order.charAt(i);
	pos[c - 'a'] = i;
  }
 Comparator<String> compare = (w1,w2) ->
  {
     int minLen = Math.min(w1.length(),w2.length());
	for(int j=0;j<minLen;j++)
{
  if(w1.charAt(j)!=w2.charAt(j))
    {
return pos[w1.charAt(j)-'a'] -   pos[w2.charAt(j) - 'a'];
    }
}
return w1.length() - w2.length();
  };
   String[] sortedWords = words.clone();
   Arrays.sort(sortedWords,compare);
  return Arrays.equals(words,sortedWords);  
    }
}

