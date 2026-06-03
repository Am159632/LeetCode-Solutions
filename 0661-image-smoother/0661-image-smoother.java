class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row=img.length;
        int col=img[0].length;
        int[][] res=new int [row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int sum=0;
                int count=0;
                for(int k=Math.max(i-1,0);k<=Math.min(i+1,row-1);k++){
                    for(int t=Math.max(j-1,0);t<=Math.min(j+1,col-1);t++){
                        sum+=img[k][t];
                        count++;
                    }
                }
                res[i][j]=sum/count;
            }
        }
        return res;
    }
}