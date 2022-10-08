class Solution {
    public String pushDominoes(String dominoes) {
        char[] input = dominoes.toCharArray();
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<input.length; i++){
            if(input[i] != '.')
            {
                if(input[i] == 'L'){
                    q.add(new int[]{1, i});
                }
                if(input[i] == 'R'){
                    q.add(new int[]{2, i});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == 1 && curr[1]>0 && input[curr[1]-1] == '.'){
                q.add(new int[]{1, curr[1]-1});
                input[curr[1]-1] = 'L';
            }
            else if(curr[0] == 2){
                int i = curr[1];
                if(i+1<input.length && input[i+1] == '.'){
                    if(i+2 < input.length && input[i+2] == 'L')
                        q.poll();
                    else{
                        q.add(new int[]{2, i+1});
                        input[i+1] = 'R';
                    }
                }
            }
        }
        return String.valueOf(input);
    }
}