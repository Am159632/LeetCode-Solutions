class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map= new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i],1);
            else map.put(words[i],map.get(words[i])+1);
        }
        int max=0;
        for(int x: map.values())
            max=Math.max(max,x);
        List<String>[] bucket = new List[max+1];
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(String key: map.keySet()){
            bucket[map.get(key)].add(key);
        }
        for(int i=0;i<bucket.length;i++){
            Collections.sort(bucket[i]);
        }
        List<String> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
            for (int j = 0; j < bucket[i].size(); j++) {
                if (res.size() == k) break;
                res.add(bucket[i].get(j));
            }
        }

        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else map.put(nums[i],map.get(nums[i])+1);
        }
        int max=0;
        for(int x: map.values())
            max=Math.max(max,x);
        List<Integer>[] bucket = new List[max+1];
        for(int i=0;i<bucket.length;i++){
            bucket[i]=new ArrayList<>();
        }
        for(int key: map.keySet()){
            bucket[map.get(key)].add(key);
        }
        int [] res=new int[k];
        for(int i=bucket.length-1;i>0;i--){
            for( int j=0;j<bucket[i].size();j++){
                if(k<=0) break;
                res[k-1]=bucket[i].get(j);
                k--;
            }
        }
        return res;
    }
}