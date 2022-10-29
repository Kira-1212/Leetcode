class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ')'){
                if(st.isEmpty() || st.peek() != '(')
                    return false;
                else
                    st.pop();
            }
            else if(c == ']'){
                if(st.isEmpty() || st.peek() != '[')
                    return false;
                else
                    st.pop();
            }
            else if(c == '}'){
                if(st.isEmpty() || st.peek() != '{')
                    return false;
                else
                    st.pop();
            }
            else{
                st.push(c);
            }
            
        }
        return st.isEmpty();
    }
}