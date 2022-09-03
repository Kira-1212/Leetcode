class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++)
            map.put(nums[i], i);
        
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i =0; i<nums.length; i++){
            int comp1 = nums[i] -k;
            int comp2 = nums[i] +k;
            if(map.containsKey(comp1)){
                List<Integer> li = new ArrayList<>();
                li.add(nums[i]);
                li.add(comp1);
                Collections.sort(li);
                if(!set.contains(li) && map.get(comp1) != i)
                    set.add(li);
            }
            if(map.containsKey(comp2)){
                List<Integer> li = new ArrayList<>();
                li.add(nums[i]);
                li.add(comp2);
                Collections.sort(li);
                if(!set.contains(li) && map.get(comp2) != i)
                    set.add(li);
            }
        }
        return set.size();
    }
}