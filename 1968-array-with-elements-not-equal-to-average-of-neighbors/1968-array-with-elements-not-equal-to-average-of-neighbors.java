class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];
        
        int l =0;
        int r = n-1;
        int i =0;
        while(i<n){
            result[i] = nums[l];
            l++;
            i++;
            if(l<=r && i<n){
                result[i] = nums[r];
                r--;
                i++;
            }
        }
        return result;
    }
}