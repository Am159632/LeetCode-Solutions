class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
            else map.put(nums[i],map.get(nums[i])+1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
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