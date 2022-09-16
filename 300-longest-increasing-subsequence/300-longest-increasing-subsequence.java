class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int  n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        for(int i = 1; i<n; i++){
            if(nums[i]>dp[len-1]){
                dp[len] = nums[i];
                len++;
            }
            else{
                int idx = binarySearch(dp, nums[i], 0, len - 1);
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    private int binarySearch(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid]>target){
                high = mid -1;
            }
            else
                low = mid +1;
        
        }
        return low;
    }
    
}