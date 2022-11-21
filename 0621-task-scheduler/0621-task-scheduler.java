class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(char c : map.keySet()){
            pq.add(map.get(c));
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!q.isEmpty() || !pq.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int count = pq.poll()-1;
                if(count!=0){
                    q.add(new int[]{count, time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}