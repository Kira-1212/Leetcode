class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0) return 0;
        int n = board.length;
        int[] moves = new int[n*n];
        int r = n-1, c = 0;
        int idx =0;
        int even =0;
        while(r>=0 && c>=0){
            if(board[r][c] == -1)
                moves[idx] =-1;
            else
                moves[idx] = board[r][c] -1;
            if(even % 2 ==0){
                c++;
                if(c == n){
                    c--;
                    r--;
                    even++;
                }
            }
            else{
                c--;
                if(c<0){
                    c++;
                    r--;
                    even++;
                }
            }
            idx++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        moves[0] = -2;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int curr = q.poll();
                if(curr == n*n -1)
                    return count;
                for(int j =1; j<=6; j++){
                    int child = j + curr;
                    if(child > n*n -1)
                        continue;
                    if(moves[child] != -2){
                        if(moves[child] == -1){
                            q.add(child);
                            moves[child] = -2;
                        }
                        else{
                            q.add(moves[child]);
                            moves[child] = -2;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}