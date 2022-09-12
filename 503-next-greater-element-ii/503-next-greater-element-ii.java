class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for(int i = 0; i<2* nums.length; i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i%nums.length]){
                int top = s.pop();
                result[top]= nums[i%nums.length];
            }
            if(i<n)  
                s.push(i);
        }
        return result;
    }
}