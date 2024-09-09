class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int rp = 1;
        result[0] = 1;

        for(int i =1; i<nums.length; i++){
            rp *= nums[i-1];
            result[i] = rp;
        }

        rp = 1;
        for(int i = nums.length-1; i>=0; i--){
            result[i] *= rp;
            rp *= nums[i];
        }
        return result;
    }
}