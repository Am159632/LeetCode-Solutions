class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] c=word.toCharArray();
            Arrays.sort(c);
            String sortedKey = new String(c);
            if(!map.containsKey(sortedKey)){
                List<String> list=new ArrayList<>();
                map.put(sortedKey,list);
            }
            map.get(sortedKey).add(word);
        }
        return new ArrayList<>(map.values());
    }
}