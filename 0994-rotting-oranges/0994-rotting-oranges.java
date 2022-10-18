class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0}, {-1,0}, {0,-1}};
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        m = grid.length;
        n = grid[0].length;
        int fresh =0;
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                for(int [] dir : dirs){
                    int nr = curr[0] +dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr>=0 && nc >= 0 && nr<m && nc<n && grid[nr][nc]==1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            level++;
        }
        if(fresh != 0)
            return-1;
        else return level >0? level-1 : 0;
    }
}