// class Solution {
//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         if (maze == null || maze.length == 0)
//             return false;
//         Queue<int[]> q = new LinkedList<>();
//         int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
//         int m = maze.length;
//         int n = maze[0].length;
//         q.add(start);
//         maze[start[0]][start[1]] = 2;
//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             for (int[] dir : dirs) {
//                 int i = curr[0];
//                 int j = curr[1];
//                 while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
//                     i = i + dir[0];
//                     j = j + dir[1];
//                 }
//                 i = i - dir[0];
//                 j = j - dir[1];
//                 if (i == destination[0] && j == destination[1]) {
//                     return true;
//                 }
//                 if (maze[i][j] == 0) {
//                     maze[i][j] = 2;
//                     q.add(new int[] { i, j });
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int m, n ;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return false;
        
         m = maze.length;
         n = maze[0].length;


        return dfs(maze, start[0], start[1], destination[0], destination[1]);
           
    }
    private boolean dfs(int[][] maze, int r, int c, int dr, int dc){
        if(r==dr && c == dc){
            return true;
        }
        if(maze[r][c] == 2)
            return false;
        maze[r][c] = 2;
        
        for(int[] dir : dirs){
            int i = r+dir[0];
            int j = c + dir[1];
            
            while (i < m && j < n && i >= 0 && j >= 0 && maze[i][j] != 1) {
                i = i + dir[0];
                j = j + dir[1];
            }
            i = i - dir[0];
            j = j - dir[1];
            if(maze[i][j] != 2 && dfs(maze, i, j, dr, dc))
                return true;
        }
        return false;
    }
}