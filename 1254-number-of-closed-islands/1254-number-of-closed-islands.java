class Solution {
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    if (grid[i][j] == 0)  dfs(grid, i, j);
                }
            }    
        }

        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) {
                    res++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] a,int i,int j){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]==1) return;

        a[i][j]=1;
        dfs(a,i-1,j);
        dfs(a,i+1,j);
        dfs(a,i,j-1);
        dfs(a,i,j+1);
    }
}