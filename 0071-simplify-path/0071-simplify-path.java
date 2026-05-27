class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        String[] words=path.split("/");
        for(int i=0;i<words.length;i++){
            if(!(words[i].isEmpty() || words[i].equals("/") || words[i].equals("."))){
                if(words[i].equals("..")) {
                    if(!list.isEmpty()) list.removeLast();
                }
                else list.addLast(words[i]);
            }
        }
        StringBuilder res=new StringBuilder();
        for(String word :list)
            res.append("/").append(word);
        return res.length() == 0 ? "/" : res.toString();
        }
}