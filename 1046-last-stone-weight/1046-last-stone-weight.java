class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i : stones){
            pq.add(i);
        }
        
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first-second);
        }
        pq.add(0);
        
        return pq.poll();
    }
}