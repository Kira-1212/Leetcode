class Solution {
    public int maxFrequency(int[] nums, int k) {
        long total  = 0;
        int j = 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            total += nums[i];
            while(nums[i] * (i-j +1) > total + k){
                total-= nums[j];
                j++;
            }
            res = Math.max(res, i - j+1);
        }
        return res;
    }
}