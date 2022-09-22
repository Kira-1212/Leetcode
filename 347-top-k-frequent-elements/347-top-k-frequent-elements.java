class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0)return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k]; 
        for( int i : nums){
            map.put(i, map.getOrDefault(i, 0) +1);
            
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
            if(pq.size()>k)
                pq.poll();
        }
        for(int j = k-1; j>=0; j--){
            result[j] = pq.poll()[0];
        }
        return result;
    }
}