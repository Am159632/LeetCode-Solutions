class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> blocks = new HashMap<>();
        for(int i=0;i<board.length;i++){
            rows.put(i,new HashSet<>());
            cols.put(i,new HashSet<>());
            blocks.put(i,new HashSet<>());
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char num=board[i][j];
                if(num!='.'){
                     if(!rows.get(i).add(num) ||
                     !cols.get(j).add(num) ||
                     !blocks.get((i/3)*3+j/3).add(num)) return false;
                }
            }
        }
        return true;
}
}