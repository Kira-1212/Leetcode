class Solution {
    int[][] dirs = new int[][]{{-1,0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c] == '0')
            return;
        grid[r][c] = '0';

        for(int[] dir : dirs){
            int nr = r+ dir[0];
            int nc = c+ dir[1];
            dfs(grid, nr, nc);
        }
    }
}