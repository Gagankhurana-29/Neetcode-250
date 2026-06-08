class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rMap = new HashMap<>();
        Map<Integer, Set<Integer>> cMap = new HashMap<>();
        Map<Integer, Set<Integer>> bMap = new HashMap<>();

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch = board[r][c];
                if(ch=='.') continue;
                int val = ch-'0';
                rMap.putIfAbsent(r,new HashSet<>());
                cMap.putIfAbsent(c,new HashSet<>());

                if(rMap.get(r).contains(val)){
                    return false;
                }
                if(cMap.get(c).contains(val)){
                    return false;
                }
                rMap.get(r).add(val);
                cMap.get(c).add(val);

                int bIndex = (r/3) * 3 + (c/3);
                bMap.putIfAbsent(bIndex,new HashSet<>());
                if(bMap.get(bIndex).contains(val)){
                    return false;
                }
                bMap.get(bIndex).add(val);
            }
        }
        return true;
    }
}
