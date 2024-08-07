class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals== null ||intervals.length == 0)return 0;
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] a : intervals){
            if(!pq.isEmpty() && pq.peek()<=a[0])
                pq.poll();
            pq.add(a[1]);
        }
        return pq.size();
    }
}