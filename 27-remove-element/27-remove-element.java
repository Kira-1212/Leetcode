class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)return 0;
        int n = nums.length;
        int l = 0;
        int r = n-1;
        
        while(l<=r){
            if(nums[l]!= val){
                l++;
            }
            else{
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
        }
        return l;
    }
}