class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length<2)return ;
        Arrays.sort(nums);
        
        int[] result = new int[nums.length];
        
        int i =0;
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r && i<nums.length){
            result[i] = nums[l];
            l++;
            i++;
            if(i<nums.length){
                result[i] = nums[r];
                i++;
                r--;
            }
        }
        for(i = 0; i<nums.length; i++)
            nums[i]=result[i];
    }
}