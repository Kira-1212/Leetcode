class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if(workers.length == 0 || bikes.length == 0  ) return new int[]{};
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < workers.length; i++){
            for(int j =0; j<bikes.length; j++){
                int dist = calculateDistance(workers[i], bikes[j]);
                if(!map.containsKey(dist)){
                    map.put(dist, new ArrayList<>());
                    
                }
                min = Math.min(min, dist);
                max = Math.max(max, dist);
                map.get(dist).add(new int[]{i, j});
                
            }
            
        }
        boolean[] assignedW = new boolean[workers.length];
        boolean[] assignedB = new boolean[bikes.length];
        int[] result = new int[workers.length];
        for(int i = min; i<=max; i++){
            if(map.containsKey(i)){
                List<int[]> wbPairs = map.get(i);
                for(int[] wb: wbPairs){
                    int w = wb[0];
                    int b = wb[1];
                    if(assignedW[w] == false){
                        if(assignedB[b] == false){
                            assignedW[w] = true;
                            assignedB[b] = true;
                            result[w] = b;
                        }
                    }
                }
            }
        }
        return result;
    }
    int calculateDistance(int[] w,int[] b){
        return Math.abs(w[0] -b[0]) +Math.abs(w[1] -b[1]);
    }
}