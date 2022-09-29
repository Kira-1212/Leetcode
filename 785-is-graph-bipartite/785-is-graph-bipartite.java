// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         if(graph == null || graph.length == 0)return true;
        
        
//         int n = graph.length;
//         int[] colors = new int[n];
//         Arrays.fill(colors, -1);
        
//         for(int i = 0; i<n; i++){
//             if(colors[i] == -1){
//                 Queue<Integer> q = new LinkedList<>();
//                 q.add(i);
//                 colors[i] = 0;
//                 while(!q.isEmpty()){
//                     int curr = q.poll();
//                     for(int j = 0; j<graph[curr].length; j++){
//                         int node = graph[curr][j];
//                         if(colors[node] == -1){
//                             colors[node]=colors[curr] == 1 ? 0 : 1;
//                             q.add(node);
//                         }
//                         else{
//                             if(colors[node] == colors[curr])
//                                 return false;
//                         }
//                     }
//                 }
                
//             }
//         }
//         return true;
//     }
// }

class Solution {
    boolean isValid;
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)return true;
        
        isValid = true;
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i = 0; i<n; i++){
            if(colors[i] == -1){
                colors[i] = 0;
                dfs(i, colors, graph);
                if(isValid == false)
                    return false;
            }
        }
        return true;
    }
    private void dfs(int v, int[] colors, int[][] graph){
        for(int i =0; i<graph[v].length; i++){
            int node = graph[v][i];
            if(colors[node] == -1){
                colors[node] = colors[v] == 1 ? 0 :1;
                dfs(node,colors, graph);
            }
            else{
                if(colors[node] == colors[v]){
                    isValid = false;
                    return;
                }
            }
        }
    }
}