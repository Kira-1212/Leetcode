class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0)
                nums[i] =0;
        }
        
        for(int i = 0; i<nums.length; i++){
            int index = Math.abs(nums[i]);
            if(index>=1 && index<=nums.length){
                if(nums[index - 1] > 0)
                    nums[index-1] = nums[index - 1] * -1;
                else if(nums[index - 1] == 0){
                    nums[index - 1] = -1 * (nums.length +1);
                }
                
            }
        }
        for(int i = 1; i<=nums.length; i++){
            if(nums[i-1] >=0)
                return i;
        }
        return nums.length +1;
    }
}