class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)-> a[0] != b[0] ? a[0]-b[0] : a[1] -b[1]);
        PriorityQueue<int[]> unavail = new PriorityQueue<>((a,b)-> a[0] != b[0] ? a[0]-b[0] : a[1] -b[1]);
        
        int[] res = new int[tasks.length];
        for(int i = 0 ; i< servers.length; i++){
            available.add(new int[]{servers[i], i});
        }
        
        int t = 0;
        for(int i = 0; i<tasks.length; i++){
            t= Math.max(t, i);
            
            if(available.isEmpty())
                t = unavail.peek()[0];
            while(!unavail.isEmpty() && t>= unavail.peek()[0]){
                int[] un = unavail.poll();
                available.add(new int[]{un[1], un[2]});
            }
            int[] a = available.poll();
            res[i] = a[1];
            unavail.add(new int[]{t+tasks[i], a[0],a[1]});
            
        }
        return res;
    }
}