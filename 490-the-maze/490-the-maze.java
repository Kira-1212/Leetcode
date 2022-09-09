class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)return false;
        Queue<int[]> q = new LinkedList<>();
        m = maze.length;
        n = maze[0].length;
        q.add(start);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dir : dirs){
                int i = curr[0];
                int j = curr[1];
                while(i<m && i>=0 && j<n && j>=0 && maze[i][j] !=1){
                    i += dir[0];
                    j += dir[1];
                }
                i -= dir[0];
                j -= dir[1];
                if(destination[0]==i && destination[1]==j )
                    return true;
                if(maze[i][j] == 0){
                    maze[i][j] = 2;
                    q.add(new int[]{i,j});
                }
            }
        }
        return false;

    }
//     private boolean dfs(int[][] maze, int[] start, int[] destination){

//         if(start[0] == destination[0] && start[1] == destination[1]){
//            return true;

//         }
//         if(maze[start[0]][start[1]] == 2)
//             return false;
//         maze[start[0]][start[1]] =2;
//         for(int[] dir : dirs){
//             int i = start[0];
//             int j = start[1];
//             while(i<m && i>=0 && j<n && j>=0 && maze[i][j] !=1){
//                 i += dir[0];
//                 j += dir[1];
//             }
//             i -= dir[0];
//             j -= dir[1];
//             if(maze[i][j] !=2 && dfs(maze, new int[]{i,j}, destination))
//                 return true;
            
//         }
//         return false;
//     }
}