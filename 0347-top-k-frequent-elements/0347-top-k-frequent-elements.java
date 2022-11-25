class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i,0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
            if(pq.size()>k)
                pq.poll();
            
        }
        int[] result = new int[k];
        int i = k-1;
        while(!pq.isEmpty()){
            result[i] = pq.poll()[0];
            i--;
        }
        return result;
    }
}