class Solution {
    List<List<String>> result;
    boolean[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0)
            return result;
        this.n = n;
        board = new boolean[n][n];
        backtrack(0);
        return result;
    }
    
    
    private void backtrack(int row){
        if(row == board.length){
            List<String> ans = new ArrayList<>();
            for(int i = 0; i<board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                ans.add(sb.toString());
            }
            result.add(ans);
            return;
        }
        for(int j = 0; j<board.length; j++){
            if(isSafe(row,j)){
                board[row][j] = true;
                backtrack(row+1);
                board[row][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c){
        for(int i = r; i>=0; i--){
            if(board[i][c])
                return false;
            
        }
        int i = r, j=c;
        while(j>=0 && i>=0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }
         j =c;
         i = r;
        while(j<board.length && i>=0){
            if(board[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
}