class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        
        int[] moves = new int[n*n];
        int r = n-1;
        int c = 0;
        int idx = 0;
        int even = 0;
        while(r>=0 && c>=0){
            if(board[r][c] == -1)
                moves[idx] = -1;
            else{
                moves[idx] = board[r][c] -1;
                
            }
            if(even %2 == 0){
                c++;
                if(c==n){
                    even++;
                    r--;
                    c--;
                }
            }
            else{
                c--;
                if(c<0){
                    even++;
                    r--;
                    c=0;
                }
            }
            idx++;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        moves[0] = -2;
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size; j++){
                int curr = q.poll();
                if(curr == n*n-1)
                    return count;
                for(int i = 1; i<=6; i++){
                    int nc = curr + i;
                    if(nc > n * n - 1)
                        continue;
                    if(moves[nc] != -2){
                        if(moves[nc] == -1){
                            q.add(nc);
                            moves[nc] = -2;
                            
                        }
                        else{
                            q.add(moves[nc]);
                            moves[nc] = -2;
                            
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
    
    
}