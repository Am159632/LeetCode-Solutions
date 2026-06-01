class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            List<Integer> l=new ArrayList<>();
            list.add(l);
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,list,visited)) return false;
            } 
        }
        return true;
    }

    public boolean dfs(int x,List<List<Integer>> list, int[] visited){
        visited[x]=1;
        for(int i=0;i<list.get(x).size();i++){
            if(visited[list.get(x).get(i)]==1) return true;
            if(visited[list.get(x).get(i)]==0) {
                 if(dfs(list.get(x).get(i),list,visited)) return true;
            }
        }
        visited[x]=2;
        return false;
    }
}