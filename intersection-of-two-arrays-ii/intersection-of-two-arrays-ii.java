class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums1){
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        List<Integer> ar = new ArrayList<>();
        
        for(int i : nums2){
            if(map.containsKey(i)){
                ar.add(i);
                int freq = map.get(i)-1;
                if(freq == 0)
                    map.remove(i);
                else
                    map.put(i, freq);
                
            }
        }
        int[] res = new int[ar.size()];
        int id = 0;
        for(int i : ar){
            res[id++] = i;
        }
        return res;
    }
}