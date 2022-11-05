class Solution {
    public int arrangeCoins(int n) {
        long low = 0; long high = n;
        while(low<=high){
            long mid = low + (high - low)/2;
            long curr = mid * (mid +1)/2;
            
            if(curr == n) return (int)mid;
            if(n<curr)
                high = mid -1;
            else
                low = mid +1;
            
        }
        return (int)high;
    }
}