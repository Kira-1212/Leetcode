class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        
        for(int n : nums)
            map.put(n, map.getOrDefault(n,0) + 1);
        
        for(int key: map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        int i =0;
        while(k>0){
            res[i++] = pq.poll()[0];
            k--;
        }
        return res;
    }
}