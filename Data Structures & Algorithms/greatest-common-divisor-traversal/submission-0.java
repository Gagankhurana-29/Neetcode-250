class DSU{
    int[] parent;
    int[] size;
    int n;

    public DSU(int n){
        this.n = n;
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for(int i=0;i<=n;i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public void unioun(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        n--;
        if(size[pu]<size[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
    }

    public int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public boolean isConnected(){
        if(this.n == 1) return true;
        return false;
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        Map<Integer,Integer> factorMap = new HashMap<>();
        DSU dsu = new DSU(nums.length);

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(num == 1) return false;
            for(int fac=2;fac*fac<=num;fac++){
                if(num%fac == 0)
                {
                    if(factorMap.containsKey(fac))
                    {
                        dsu.unioun(i,factorMap.get(fac));
                    }
                    else{
                        factorMap.put(fac,i);
                    }
                    while (num % fac == 0) {
                num /= fac;
            }
                }
            }
            if(num>1)
            {
                if(factorMap.containsKey(num))
                    {
                        dsu.unioun(i,factorMap.get(num));
                    }
                    else{
                        factorMap.put(num,i);
                    }
            }
        }
        return dsu.isConnected();
    }
}