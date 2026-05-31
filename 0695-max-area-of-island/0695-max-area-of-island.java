class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int max=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) grid[i][j]=dfs(grid,i,j);
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(max<grid[i][j]) max=grid[i][j];
            }
        }
        return max;
    }

    private int dfs(int[][] a,int i,int j){
        if(i<0 || i>=a.length || j<0 || j>=a[0].length || a[i][j]!=1) return 0;

        a[i][j]=0;
        return 1+dfs(a,i-1,j)+dfs(a,i+1,j)+dfs(a,i,j+1)+dfs(a,i,j-1);
    }
}