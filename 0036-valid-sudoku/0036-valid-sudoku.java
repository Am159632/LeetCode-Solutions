class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    for(int k=0;k<board.length;k++){
                        if(k!=i && board[i][j]==board[k][j]) return false;
                        if(k!=j && board[i][j]==board[i][k]) return false;
                    }
                    int row=(i/3)*3,col=(j/3)*3;
                    for(int k=row;k<row+3;k++){
                        for(int t=col;t<col+3;t++){
                            if(k!=i || t!=j){
                                if(board[i][j]==board[k][t]) return false;
                            }
                        }
                    }
                }
            }   
        }
        return true;
    }
}