class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int min = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) { 
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                int[] current = q.remove();
                int r = current[0]; 
                int c = current[1];
                
                if (r > 0 && grid[r - 1][c] == 1) {
                    fresh--;
                    grid[r - 1][c] = 2;
                    q.add(new int[]{r - 1, c});
                }
                if (c > 0 && grid[r][c - 1] == 1) {
                    fresh--;
                    grid[r][c - 1] = 2;
                    q.add(new int[]{r, c - 1});
                }
                if (r < grid.length - 1 && grid[r + 1][c] == 1) {
                    fresh--;
                    grid[r + 1][c] = 2;
                    q.add(new int[]{r + 1, c});
                }
                if (c < grid[0].length - 1 && grid[r][c + 1] == 1) {
                    fresh--;
                    grid[r][c + 1] = 2;
                    q.add(new int[]{r, c + 1});
                }
            }
            min++;
        }
        
        return fresh == 0 ? min : -1;
    }
}