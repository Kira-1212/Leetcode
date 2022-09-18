class Solution {
    List<List<Integer>> graph;
    List<List<Integer>> result;
    int[] discovery;
    int[] lowest;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(n ==0) return new ArrayList<>();
        discovery = new int[n];
        lowest = new int[n];
        Arrays.fill(discovery, -1);
        graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        result = new ArrayList<>();
        buildGraph(connections);
        dfs(0,0);
        return result;
        
    }
    private void buildGraph(List<List<Integer>> connections){
        for( List<Integer> edge : connections){
            int from = edge.get(0);
            int to = edge.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }
    private void dfs(int v, int u){
        
        if(discovery[v] != -1)return;
        discovery[v] =time;
        lowest[v] = time;
        time++;
        
        List<Integer> children = graph.get(v);
        if(children != null){
            for(int n : children){
                if(n==u)continue;
                dfs(n,v);
                if(lowest[n]>discovery[v]){
                    result.add(Arrays.asList(n,v));
                }
                lowest[v] = Math.min(lowest[v],lowest[n]);
            }
        }
    }
}