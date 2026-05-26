class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1') {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] a,int i,int j){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]=='0') return;

        a[i][j]='0';
        dfs(a,i-1,j);
        dfs(a,i+1,j);
        dfs(a,i,j-1);
        dfs(a,i,j+1);
    }
}