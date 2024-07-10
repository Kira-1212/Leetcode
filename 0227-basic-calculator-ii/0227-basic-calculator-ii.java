class Solution {
    public int calculate(String s) {
        if(s == null || s.length() ==0) return 0;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        int current = 0;
        char operator = '+';

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                current = current * 10 + (c-'0');

            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() -1){
                if(operator == '+')
                    st.push(current);
                if(operator == '-')
                    st.push(-current);
                if(operator == '*')
                    st.push(st.pop() * current);
                if(operator == '/')
                    st.push(st.pop() / current);
                operator =c;
                current = 0;
            }


        }
        while(!st.isEmpty())
            result+=st.pop();
        return result;
    }
}