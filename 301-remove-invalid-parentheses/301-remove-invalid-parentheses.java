class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0)return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
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
                for(int i =0; i<curr.length(); i++){
                    if(Character.isLetter(curr.charAt(i)))continue;
                    String newCurr = curr.substring(0, i) + curr.substring(i+1);
                    if(!set.contains(newCurr)){
                        set.add(newCurr);
                        q.add(newCurr);
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        int count =0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                count++;
            else if(c == ')')
                count--;
            else continue;
            if(count<0)
                return false;
        }
        return count == 0;
    }
}