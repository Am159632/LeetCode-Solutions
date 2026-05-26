class TimeMap {
    Map<String,List<Pair>> map;
    public TimeMap() {
       map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            List<Pair> p=new ArrayList<>();
            map.put(key,p);
        }
        map.get(key).add(new Pair(timestamp,value));
    }

    public String get(String key, int timestamp) {
         if(!map.containsKey(key)|| map.get(key).get(0).timestamp>timestamp) return "";
         return bs(map.get(key),timestamp);
    }

    public String bs(List<Pair> list,int x){
    int s=0,e=list.size()-1;
    while(s<=e){
        int mid=(e+s)/2;
        if(list.get(mid).timestamp==x) return list.get(mid).value;
        if(list.get(mid).timestamp>x) e=mid-1;
        if(list.get(mid).timestamp<x) s=mid+1;
    }
    return list.get(e).value;
    }
}

class Pair {
    int timestamp;
    String value;

    public Pair(int t,String v){
        timestamp=t;
        value=v;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */