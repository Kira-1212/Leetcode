class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strS = new Stack<>();
        Stack<Integer> numS = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num *10 + c-'0';
            }
            else if(c =='['){
                numS.push(num);
                strS.push(sb);
                num = 0;
                sb = new StringBuilder();
            }
            else if(c == ']'){
                int times = numS.pop();
                StringBuilder newsb = new StringBuilder();
                for(int j = 0; j<times; j++)
                    newsb.append(sb);
                sb = strS.pop().append(newsb);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}