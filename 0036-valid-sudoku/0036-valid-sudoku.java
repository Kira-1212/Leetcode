class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] blocks = new HashSet[9];
        
        for(int i = 0; i<9; i++){
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            blocks[i] = new HashSet();
        }
        
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                char c = board[i][j];
                if(c == '.')
                    continue;
                if(rows[i].contains(c)){
                    return false;
                }
                
                rows[i].add(c);

                if(cols[j].contains(c))
                    return false;
                cols[j].add(c);
                int block = i/3 * 3 + j/3;
                
                if(blocks[block].contains(c))
                    return false;

                blocks[block].add(c);
            }
        }
        return true;
    }
}
