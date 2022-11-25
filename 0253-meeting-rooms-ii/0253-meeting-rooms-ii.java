class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] i : intervals){
            if(!pq.isEmpty() && pq.peek()<=i[0]){
                
                    pq.poll();
                
            }
            pq.add(i[1]);
        }
        return pq.size();
    }
}