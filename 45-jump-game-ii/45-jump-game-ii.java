class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2 || nums == null) return 0;
        int n = nums.length;
        int curr = nums[0];
        int next = nums[0];
        int jumps =1;
        for(int i = 0; i<n; i++){
            next = Math.max(next, i+nums[i]);
            if(i<n-1 && i == curr){
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}