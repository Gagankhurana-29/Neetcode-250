class Unioun
{
    private int[] parent;
    private int[] rank;

    public Unioun(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }  
        return parent[x];
    }

    public void union(int x1, int x2){
        int p1 = find(x1);
        int p2 = find(x2);
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            parent[p1] = p2;
            rank [p2] += rank[p1];
        }
    }

}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Unioun un = new Unioun(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        for(int i=0;i<n;i++){
            List<String> emails = accounts.get(i);
            for(int j=1;j<emails.size();j++){
                String email = emails.get(j);
                if(emailToAcc.containsKey(email)){
                    un.union(i,emailToAcc.get(email));
                }
                else{
                    emailToAcc.put(email,i);
                }
            }
        }        

     Map<Integer, List<String>> emailgroup = new HashMap<>();
     
     for(Map.Entry<String,Integer> entry : emailToAcc.entrySet()){
            String email = entry.getKey();
             int accId = entry.getValue();
             int leader = un.find(accId);
             emailgroup.putIfAbsent(leader, new ArrayList<>());
             emailgroup.get(leader).add(email);       
     }

      List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : emailgroup.entrySet()){
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> ans = new ArrayList<>();
            ans.add(accounts.get(accId).get(0));
            ans.addAll(emails);
            res.add(ans);
        }
        return res;
    }
}