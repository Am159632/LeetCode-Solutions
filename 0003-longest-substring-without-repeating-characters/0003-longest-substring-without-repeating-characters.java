class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s==null) return 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int r=1,l=0,max=1;
        while(r<s.length()){
            char c= s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                max=Math.max(max,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}