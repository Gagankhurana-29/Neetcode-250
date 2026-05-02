class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topSort(k,rowConditions);
        if(rowOrder.length < k) return new int[0][0];
        int[] colOrder = topSort(k,colConditions);
        if(colOrder.length < k) return new int[0][0];

        Map<Integer,Integer> valToRow = new HashMap<>();
        for(int i=0;i<k;i++){
            valToRow.put(rowOrder[i],i);
        }

        Map<Integer,Integer> valToCol = new HashMap<>();
        for(int i=0;i<k;i++){
            valToCol.put(colOrder[i],i);
        }

        int[][] res = new int[k][k];
        for(int num=1;num<=k;num++){
            int r = valToRow.get(num);
            int c = valToCol.get(num);
            res[r][c] = num;
        }
        return  res;
    }

    public int[] topSort(int k, int[][] nums){
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=k;i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k+1];       

        for(int[] num : nums){
            graph.get(num[0]).add(num[1]);
            indegree[num[1]]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for(int i=1;i<=k;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }

        int[] ans = new int[k];
        int idx=0;
        while(!qu.isEmpty()){
            int val = qu.poll();
            ans[idx++] = val;
            for(int al : graph.get(val)){
                indegree[al]--;
                if(indegree[al]==0){
                    qu.offer(al);
                }
            }
        }
        if(idx != k) return  new int[0];
        return ans;
    }

}