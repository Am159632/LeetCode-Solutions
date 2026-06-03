class Solution {

    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] res = new int[rows][cols];
        
        int[] rowSums = new int[cols];
        
        for (int i = 0; i < rows; i++) {
            int currentSum = 0;
            
            for (int c = 0; c <= Math.min(1, cols - 1); c++) {
                currentSum += img[i][c];
            }
            
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols) currentSum += img[i][j + 1];
                if (j - 2 >= 0) currentSum -= img[i][j - 2];
                rowSums[j] = currentSum;
            }
            
            for (int j = 0; j < cols; j++) {
                int colSum = rowSums[j];
                int rStart = Math.max(0, i - 1);
                int rEnd = Math.min(rows - 1, i + 1);
                int cStart = Math.max(0, j - 1);
                int cEnd = Math.min(cols - 1, j + 1);
                
                if (i - 1 >= 0 && i + 1 < rows) {
                    colSum = rowSums[j];
                    for (int c = Math.max(0, j - 1); c <= Math.min(cols - 1, j + 1); c++) {
                        if (i - 2 >= 0) {} 
                    }
                }
                
                int totalSum = 0;
                for (int r = rStart; r <= rEnd; r++) {
                    int tempSum = 0;
                    for (int c = cStart; c <= cEnd; c++) {
                        tempSum += img[r][c];
                    }
                    totalSum += tempSum;
                }
                
                res[i][j] = totalSum / ((rEnd - rStart + 1) * (cEnd - cStart + 1));
            }
        }
        
        return res;
    }

    public int[][] imageSmoother1(int[][] img) {
        int row=img.length;
        int col=img[0].length;
        int[][] res=new int [row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int rs=Math.max(i-1,0);
                int re=Math.min(i+1,row-1);
                int cs=Math.max(j-1,0);
                int ce=Math.min(j+1,col-1);
                int sum=0;
                for(int k=rs;k<=re;k++){
                    for(int t=cs;t<=ce;t++){
                        sum+=img[k][t];
                    }
                }
                res[i][j]=sum/((re-rs+1)*(ce-cs+1));
            }
        }
        return res;
    }
}