class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int curr_max = nums[0];
        for(int i = 1; i<nums.length; i++){
            curr_max = Math.max(nums[i], curr_max+nums[i]);
            max = Math.max(curr_max, max);
        }
        return max;
    }
}