class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0)return 0;
        int low = 0, high = 0;
        for( int i : weights){
            low = Math.max(low, i);
            high += i;
        }
        
        while(low<=high){
            int mid = low + (high - low)/2;
            int d = 1;
            int currWt = 0;
            for( int i  = 0; i<weights.length; i++){
                if(currWt+weights[i] <= mid)
                    currWt += weights[i];
                else{
                    d++;
                    currWt = weights[i];
                }
            }
            if(d>days){
                low = mid +1;
                
            }
            else
                high = mid -1;
        }
        return low;
    }
}