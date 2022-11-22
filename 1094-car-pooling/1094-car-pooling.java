class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)-> a[1] -b[1]);
        int numPass = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] t : trips){
            while(!pq.isEmpty() && pq.peek()[0] <=t[1]){
                numPass-=pq.poll()[1];
                
            }
            numPass+=t[0];
            if(numPass>capacity)
                return false;
            pq.add(new int[]{t[2],t[0]});
        }
        return true;
    }
}