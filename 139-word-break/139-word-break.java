class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s== null || s.length() ==0)return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(int j =0; j<i; j++){
                if(dp[j]){
                    if(set.contains(s.substring(j, i)))
                        dp[i]= true;
                }
            }
        }
        return dp[s.length()];
    }
}