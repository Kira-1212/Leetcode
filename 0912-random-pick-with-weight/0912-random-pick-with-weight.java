class Solution {
    int[] prefixSums;
    int totalSum;
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        totalSum = 0;
        
        for(int i = 0; i<w.length; i++){
            totalSum+=w[i];
            prefixSums[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        double target = Math.random() * totalSum;

        int low = 0; 
        int high = prefixSums.length;
        while(low<high){
            int mid = low + (high - low)/2;
            if(target<prefixSums[mid])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */