class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int n = nums.length;
        int min = n+1;
        
        int sum = 0;
        
        for(int i = 0; i<n; i++){
            sum+=nums[i];
            
            while(sum>=target){
                min = Math.min(min, i-j+1);
                sum-=nums[j];
                j++;
            }

        }
        return min == n+1 ? 0 : min;
    }
}