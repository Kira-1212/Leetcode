/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 0 )return -1;
        
        int[] indegrees = new int[n];
        for( int i =0; i<n; i++){
            for( int j =0; j<n ; j++){
                if( i== j) continue;
                if(knows(i, j)){
                    indegrees[i]--;
                    indegrees[j]++;
                }
            }
        }
        for( int i = 0; i<n; i++){
            if(indegrees[i] == n-1)
                return i;
        }
        return -1;
    }
}