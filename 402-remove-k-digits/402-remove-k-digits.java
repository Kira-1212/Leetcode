class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null) return "0";
        Stack<Character> s = new Stack<>();
        for( char digit : num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek()>digit){
                s.pop();
                k--;
            }
            s.push(digit);
        }
        
        for(int i =0; i<k ; i++)
            s.pop();
        StringBuilder result = new StringBuilder();
        boolean leadingZero= true;
        for(char digit : s){
            if(leadingZero && digit == '0')continue;
            leadingZero = false;
            result.append(digit);
        }
        if(result.length() == 0)return "0";
        return result.toString();
    }
}