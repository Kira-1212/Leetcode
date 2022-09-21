class Solution {
    int side;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0)return false;
        
        int sum = 0;
        for(int i : matchsticks){
            sum+= i;
        }
        if(sum %4 != 0)return false;
        side = sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] result = new int[4];
        return backtrack(matchsticks, result, 0);
        
    }
    private boolean backtrack(int[] nums, int[] result, int i){
        
        if(result[0] == side && result[1] == side && result[2] == side && result[3] == side)
            return true;
        if(i==nums.length)
            return false;
        
        
        for(int j =0; j<4; j++){
            if(result[j] + nums[i]<=side){
                result[j]+=nums[i];
                if(backtrack(nums, result, i+1))
                    return true;
                result[j]-=nums[i];
            }
            
        }
        return false;
        
    }
    private void reverse(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}