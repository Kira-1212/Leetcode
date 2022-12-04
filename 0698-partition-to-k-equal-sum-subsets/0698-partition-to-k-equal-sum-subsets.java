class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
            
        }
        if(sum % k != 0)return false;
        int target = sum/k;
        
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, k, 0, used, target, 0);
        
    }
    private boolean backtrack(int[] nums, int k, int i, boolean[] used, int target, int subsetSum){
        if(k==0)
            return true;
        if(target == subsetSum){
            return backtrack(nums, k-1, 0, used, target, 0);
        }
        
        for(int j = i; j<nums.length; j++){
            if(used[j] || subsetSum+nums[j]>target)
                continue;
            used[j] = true;
            if(backtrack(nums, k, j+1, used, target, subsetSum + nums[j]))
                return true;
            used[j] = false;
            
        }
        return false;
    }
}