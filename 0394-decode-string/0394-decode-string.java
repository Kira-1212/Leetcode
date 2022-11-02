class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        
        Stack<Integer> sint = new Stack<>();
        Stack<StringBuilder> sstr = new Stack<>();
        int curr = 0;
        StringBuilder currStr = new StringBuilder();
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c-'0';
            }
            else if(Character.isAlphabetic(c)){
                currStr.append(c);
            }
            else if(c== '['){
                sint.push(curr);
                sstr.push(currStr);
                currStr = new StringBuilder();
                curr =0;
            }
            else{
                int times = sint.pop();
                StringBuilder newstr = new StringBuilder();
                for(int j =0; j<times; j++){
                    newstr.append(currStr);
                }
                currStr = sstr.pop().append(newstr);
            }
        }
        return currStr.toString();
    }
}