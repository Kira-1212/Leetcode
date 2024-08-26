class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}