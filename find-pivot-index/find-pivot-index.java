class Solution {
    public int pivotIndex(int[] nums) {
        int presum = 0;
        int sum = 0;
        for(int n : nums)
            sum+=n;
        for(int i = 0; i<nums.length; i++){
            int leftover = sum - nums[i] - presum;
            if(presum == leftover)
                return i;
            presum+=nums[i];
        }
        return -1;
    }
}