class Solution {
    int[][] dirs = new int[][]{{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0,1}, {1, 0}, {1,1}, {1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        if(grid[0][0] != 0 || grid[m][n] != 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            int distance = grid[r][c];

            if(r == m && c == n)
                return distance;

            for(int[] e : getNeighbors(r,c, grid, m, n)){
                int nr = e[0];
                int nc = e[1];
                q.add(e);
                grid[nr][nc] = distance + 1;
            }
        }
        return -1;
 
 
 
    }

    private List<int[]> getNeighbors(int r, int c, int[][] grid, int m, int n){
        List<int[]> neighbors = new ArrayList<>();
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr<0 || nc <0 || nr >= m+1 || nc >= n +1 || grid[nr][nc] != 0)
                continue;
            neighbors.add(new int[]{nr,nc});
        }
        return neighbors;
    }
}