class Solution {
    public int minimumDifference(int[] nums, int k) {
        int l = 0;
        int min = Integer.MAX_VALUE;
        int r = k-1;
        Arrays.sort(nums);
        while(r<nums.length){
            min = Math.min(min, nums[r]-nums[l]);
            l++;
            r++;
        }
        return min;
    }
}