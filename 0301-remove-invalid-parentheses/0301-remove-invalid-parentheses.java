class Solution {
    HashSet<String> set;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                found = true;
                result.add(curr);
            }
            else if(!found){
                for(int j = 0; j<curr.length(); j++){
                    if(Character.isLetter(curr.charAt(j)))
                        continue;
                    String sub = curr.substring(0, j) + curr.substring(j+1);
                    if(!set.contains(sub)){
                        q.add(sub);
                        set.add(sub);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            char c= s.charAt(i);
            
            if(c=='(')
                count++;
            else if(c==')')
                count--;
            else
                continue;
            if(count<0)
                return false;
        }
        return count == 0;
    }
}