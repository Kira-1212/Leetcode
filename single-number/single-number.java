class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums){
            if(set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }
        for(int i : set)
            return i;
        return -1;
    }
}