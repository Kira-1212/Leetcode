class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int n : nums){
            low = Math.max(low, n);
            high += n;
        }
        int res = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canSplit(nums,k, mid)){
                res= mid;
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return res;
    }
    private boolean canSplit(int[] nums, int k, int sum){
        int currSum = 0;
        int splits = 0;
        for(int n : nums){
            currSum += n;
            if(currSum> sum){
                splits++;
                currSum = n;
            }
        }
        return splits+1<=k;
    }
}