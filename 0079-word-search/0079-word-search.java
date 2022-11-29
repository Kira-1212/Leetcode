class Solution {
    boolean result;
    int[][] dirs = new int[][]{ {-1,0},{1,0},{0,1}, {0,-1}};
    int m, n;
    public boolean exist(char[][] board, String word) {
        result = false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(backtrack(board, word, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int r, int c){
        if(r<0 || c<0 || r>= m || c >= n || board[r][c] == '#')
            return false;
        if(word.charAt(0) == board[r][c]){
            if(word.length() == 1)return true;
            char ch = board[r][c] ;
            board[r][c] = '#';
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c+ dir[1];
                if(backtrack(board, word.substring(1), nr, nc))
                    return true;
            }
            board[r][c] = ch;
        }
        return false;
    }
}