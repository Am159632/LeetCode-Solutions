class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }   
        int max=0,cur;
        for(int x:set){
            if(!set.contains(x-1)){
                cur=0;
                while(set.contains(x)){
                    cur++;
                    x++;
                }
                if(cur>max) max=cur;
            }
        }
        return max;
    }
}