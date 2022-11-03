class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();
        
        for(char c : s.toCharArray()){
            int n = c-'a';
            if(!st.isEmpty() && st.peek()[0] == n){

                if(st.peek()[1] + 1 == k)
                    st.pop();
                else{
                    int[] temp = st.pop();
                    temp[1]+=1;
                    st.push(temp);
                }
            }
            else
                st.push(new int[]{n, 1});
        }
        StringBuilder sb = new StringBuilder();
    
        for(int [] val : st){
            int times = val[1];
            for(int i =0; i<times; i++){
                sb.append((char)(val[0] + 97));
            }
        }
        return sb.toString();
    }
}