class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> s = new Stack<>();
        int currMin = nums[0];
        for(int i = 1; i<nums.length; i++){
            while(!s.isEmpty() && s.peek()[0]<=nums[i]){
                s.pop();
            }
            if(!s.isEmpty() && s.peek()[1] < nums[i])
                return true;
            s.push(new int[] {nums[i], currMin});
            
            currMin = Math.min(nums[i], currMin);
        }
        return false;
    }
}