class Solution {
    int m, n;
    int[][] dirs;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0)
            return board;

        m = board.length;
        n = board[0].length;

        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
        Queue<int[]> q = new LinkedList<>();
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        q.add(new int[]{click[0],click[1]});
        board[click[0]][click[1]] = 'B';
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int count = getCount(board, curr[0], curr[1]);
            if(count>0){
                board[curr[0]][curr[1]] = (char)(count + '0');
            }
            else{
                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr<m && nc <n && nr>=0 && nc>= 0 && board[nr][nc] == 'E'){
                        board[nr][nc] = 'B';
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }
        return board;                     
    }
    private int getCount(char[][] board, int r, int c){
        int count = 0;
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr<m && nc <n && nr>=0 && nc>= 0 && board[nr][nc] == 'M'){
                count++;
            }
        }
        return count;
    }
}