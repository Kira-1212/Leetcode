class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1){
            return 0;
        }
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}