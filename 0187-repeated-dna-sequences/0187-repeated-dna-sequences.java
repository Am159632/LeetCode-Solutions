class Solution {
     public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<>();
        Set<String> res=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String key=s.substring(i,i+10);
            if(!set.contains(key)) set.add(key);
            else res.add(key);
        }
        List<String> list=new ArrayList<>(res);
        return list;
    }
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> set=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String key=s.substring(i,i+10);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        List<String> list=new ArrayList<>();
        for(String key: map.keySet()){
            if(map.get(key)>1) list.add(key);
        }
        return list;
    }
}