class Pair{
    public int time;
    public String val;

    public Pair(int t, String val)
    {
        this.time = t;
        this.val = val; 
    }
}

class TimeMap {

    Map<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        if(!map.containsKey(key))
        {
             map.put(key,new ArrayList<>());
        }
        map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> pairs = map.get(key);
        int high =  pairs.size()-1;
        int low = 0;
        String res = "";
        while(low<=high){
            int mid = low + (high-low)/2;
            if(pairs.get(mid).time<=timestamp)
            {
                low = mid+1;
                res = pairs.get(mid).val;
            }
            else{
                high= mid-1;
            }
        }
        return res;
    }
}
