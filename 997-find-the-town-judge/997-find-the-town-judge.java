class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] outdegrees = new int[n+1];
        int[] indegrees = new int[n+1];
        for(int[] t : trust){
            outdegrees[t[0]]++;
            indegrees[t[1]]++;
        }
        int result =-1;
        for(int i = 1; i<=n; i++){
            if(outdegrees[i]==0)
                if(indegrees[i] == n-1)
                    result = i;
            }
        return result;
    }
}