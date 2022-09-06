class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int calc = 0, tail =0;
        int curr = 0;
        char lastsign = '+';
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr *10+ c-'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                if(lastsign  == '+'){
                    calc = calc +curr;
                    tail = curr;
                }
                else if(lastsign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastsign == '*'){
                    calc = calc-tail + tail * curr;
                    tail = tail * curr;
                }
                else{
                    calc = calc - tail + tail/curr;
                    tail = tail/curr;
                }
                lastsign = c;
                curr = 0;
            }
        }
        return calc;
    }
}