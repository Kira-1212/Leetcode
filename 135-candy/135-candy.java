class Solution {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1])
                candies[i] = candies[i+1] +1;
            
        }
        int sum = candies[0];
        for(int i = 1; i<n; i++){
            if(ratings[i-1]<ratings[i]){
                candies[i] = Math.max(candies[i], candies[i-1] +1);
            }
            sum += candies[i];
        }
        return sum;
    }
}