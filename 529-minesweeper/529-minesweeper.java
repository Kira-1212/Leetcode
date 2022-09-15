// class Solution {
//     int m, n;
//     int[][] dirs;
//     public char[][] updateBoard(char[][] board, int[] click) {
//         if(board == null || board.length == 0) return board;
//         m = board.length;
//         n = board[0].length;
//         dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
//         if(board[click[0]][click[1]] == 'M'){
//             board[click[0]][click[1]] = 'X';
//             return board;
//         }
//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[] { click[0], click[1]});
//         board[click[0]][click[1]] = 'B';
        
//         while(!q.isEmpty()){
//             int[] curr = q.poll();
//             int count = countMines(board, curr[0], curr[1]);
//             if(count>0){
//                 board[curr[0]][curr[1]] = (char)(count+'0');
                
//             }
//             else{
//                 for(int[] dir : dirs){
//                     int r = curr[0] + dir[0];
//                     int c = curr[1] + dir[1];
//                     if(r>=0 && c>=0 && r<m && c<n && board[r][c] == 'E'){
//                         board[r][c] = 'B';
//                         q.add(new int[]{r,c});
//                     }
//                 }
//             }
//         }
//         return board;
//     }
class Solution {
    int m, n;
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length == 0) return board;
        m = board.length;
        n = board[0].length;
        dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        dfs(board, click[0], click[1]);
       
        return board;
    }
    private void dfs(char[][] board, int r, int c){
        
        if(r<0 || c<0 || r==m || c==n || board[r][c] != 'E')return;
        
        board[r][c] = 'B';
        int count = countMines(board, r, c);
        if(count>0)
            board[r][c] = (char)(count+'0');
        else{
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                dfs(board,nr, nc);
            }
        }
    }
    private int countMines(char[][] board, int r , int c){
        int count =0;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc] == 'M'){
                count++;
            }
            
        }
        return count;
    }
}