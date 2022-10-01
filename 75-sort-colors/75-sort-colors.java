class Solution {
    public void sortColors(int[] nums) {
        int l =0 , curr =0;
        int r = nums.length-1;
        while(curr<=r){
            if(nums[curr] == 0){
                swap(nums, l, curr);
                curr++;
                l++;
            }
            else if(nums[curr] == 2){
                swap(nums, curr, r);
                r--;
                
            }
            else
                curr++;
            
            
        }
    }
    private void swap(int[] nums, int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}