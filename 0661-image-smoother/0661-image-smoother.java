class Solution {
    public int[][] imageSmoother(int[][] img) {
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
                int count=0;
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