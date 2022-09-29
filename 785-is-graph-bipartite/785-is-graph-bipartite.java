class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)return true;
        
        
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i = 0; i<n; i++){
            if(colors[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j = 0; j<graph[curr].length; j++){
                        int node = graph[curr][j];
                        if(colors[node] == -1){
                            colors[node]=colors[curr] == 1 ? 0 : 1;
                            q.add(node);
                        }
                        else{
                            if(colors[node] == colors[curr])
                                return false;
                        }
                    }
                }
                
            }
        }
        return true;
    }
}