class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        
        for(int i = 2; i<n+1; i++){
            int total = 0;
            for(int j = 1; j<i+1; j++){
                int left = j - 1;
                int right = i -j;
                total += dp[left]* dp[right];
            }
            dp[i] = total;
        }
        return dp[n];            
    }
}