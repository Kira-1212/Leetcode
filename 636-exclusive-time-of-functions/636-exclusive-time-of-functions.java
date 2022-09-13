class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null)return new int[]{};
        int[] result = new int[n];
        int prev = 0;
        Stack<Integer> s = new Stack<>();
        for(String log : logs){
            String[] strs = log.split(":");
            int curr = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()]+= curr-prev;
                    
                }
                prev = curr;
                s.push(Integer.parseInt(strs[0]));
            }
            else{
                result[s.pop()] += curr +1 -prev;
                prev =curr +1;
            }
        }
        return result;
    }
}