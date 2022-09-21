class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n == 0)return 0;
        uf = new int[n+1];
        for( int i = 0; i<uf.length; i++)
            uf[i] = i;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i<wells.length; i++){
            edges.add(new int[]{0, i+1, wells[i]});
        }
        for(int[] pipe : pipes)
            edges.add(pipe);
        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        int cost = 0;
        for( int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            int px = find(x);
            int py = find(y);
            if(px != py){
                uf[px] = py;
                cost += edge[2];
            }
        }
        return cost;
    }
    private int find(int x){
        if(uf[x] != x){
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }
}