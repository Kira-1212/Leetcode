class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegrees = new int[n+1];
        
        for(int[] t : trust){
            indegrees[t[0]]--;
            indegrees[t[1]]++;
        }
        
        for(int i = 1; i<=n; i++){
            if(indegrees[i] == n-1)
                return i;
        }
        return -1;
    }
}