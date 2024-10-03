class Solution {
    public int calculate(String s) {
        int result = 0;
        char operator = '+';
        Stack<Integer> st = new Stack<>();
        int current = 0;
        for(int i = 0; i<s.length(); i++){
            char c =s.charAt(i);
            if(Character.isDigit(c)){
                current = current *10 + (c-'0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i==s.length()-1){
                if(operator == '+')
                    st.push(current);
                if(operator ==  '-')
                    st.push(-current);
                if(operator == '*'){
                    st.push(st.pop()*current);
                }
                if(operator == '/'){
                    st.push(st.pop() / current);
                }
                current = 0;
                operator = c;
            }


        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}