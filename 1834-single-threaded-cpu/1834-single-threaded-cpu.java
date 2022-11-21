class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));
        int[][] sorted = new int[tasks.length][3];
        for(int i = 0; i<tasks.length; i++){
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }
        int res[] = new int[tasks.length];
        Arrays.sort(sorted, (a,b) -> a[0] - b[0]);
        int i = 0;
        int currTime = 0;
        int ansIndex = 0;
        while(i<tasks.length || !pq.isEmpty()){
            if(pq.isEmpty() && currTime<sorted[i][0])
                currTime=sorted[i][0];
        
            while(i<tasks.length && currTime >= sorted[i][0]){
                pq.add(sorted[i]);
                i++;
            }
            int procTime = pq.peek()[1];
            int index = pq.peek()[2];
            currTime += procTime;
            pq.poll();
            res[ansIndex]=index;
            ansIndex++;
        }
        return res;
    }
    
}