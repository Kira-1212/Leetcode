class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null) return 0;
        Stack<Integer> s = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String st : tokens){
            if(set.contains(st)){
                int first = s.pop();
                int second = 0;
                if(!s.isEmpty())
                    second = s.pop();
                if(st.equals("+")){
                    s.push(first + second);
                }
                else if(st.equals("-")){
                    s.push(second - first);
                }
                else if(st.equals("*")){
                    s.push(second * first);
                }
                else if(st.equals("/")){
                    s.push(second / first);
                }
            }
            else
                s.push(Integer.parseInt(st));
        }
        return s.pop();
    }
}