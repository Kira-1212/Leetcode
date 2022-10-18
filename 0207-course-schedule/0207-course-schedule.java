// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         Map<Integer, List<Integer>>map = new HashMap<>();
//         int[] indegrees = new int[numCourses];
//         for(int[] req : prerequisites){
//             if(!map.containsKey(req[0])){
//                 map.put(req[0], new ArrayList<>());
//             }
//             map.get(req[0]).add(req[1]);
//             indegrees[req[1]]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0; i<numCourses; i++){
//             if(indegrees[i] == 0){
//                 q.add(i);
//             }
//         }
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             List<Integer> neighbors = map.get(curr);
//             if(neighbors != null)
//             for(int n : neighbors){
//                 indegrees[n]--;
//                 if(indegrees[n] == 0)
//                     q.add(n);
                
//             }
//         }
//         for(int i = 0 ; i<numCourses ; i++){
//             if(indegrees[i] != 0)
//                 return false;
//         }
//         return true;
//     }
// }

class Solution {
    Map<Integer, List<Integer>>map;
    boolean[] visited;
    boolean[] path;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for(int[] req : prerequisites){
            if(!map.containsKey(req[1])){
                map.put(req[1], new ArrayList<>());
            }
            map.get(req[1]).add(req[0]);

        }

        for(int i = 0; i<numCourses; i++){
            if(!visited[i] && hasCycle(i)){
                return false;
            }
        }

        return true;
    }
    private boolean hasCycle(int i){
        if(path[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        path[i] = true;
        List<Integer> neighbors = map.get(i);
            if(neighbors != null)
                for(int n : neighbors){
                    if(hasCycle(n))
                        return true;

                }
        path[i] = false;
        return false;
    }
}