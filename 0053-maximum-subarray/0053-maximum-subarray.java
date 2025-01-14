class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null)
            return 0;
        int currMax = nums[0];
        int maxMax = nums[0];

        for(int i = 1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxMax = Math.max(currMax, maxMax);
        }
        return maxMax;
    }
}