class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int n: nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        int[] count = new int[max-min +1];
        for(int n: nums){
            count[n-min]++;
        }
        for(int i = count.length-1; i>=0; i--){
            k-=count[i];
            if(k<=0)
                return i+min;
        }
        return -1;
    }
}