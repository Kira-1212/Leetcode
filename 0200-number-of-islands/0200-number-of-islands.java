class Solution {
    int m , n;
    
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c){
        if(r== m ||c == n || r<0 || c<0 || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            dfs(grid, nr, nc);
        }
    }
}