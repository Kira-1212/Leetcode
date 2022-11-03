class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!s.isEmpty() && k>0 && s.peek() > digit){
                s.pop();
                k--;
            }
            s.push(digit);
        }
        for(int i=0; i<k; ++i) {
            s.pop();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: s) {
          if(leadingZero && digit == '0') continue;
          leadingZero = false;
          sb.append(digit);
        }
        return sb.length() == 0 ? "0": sb.toString();
    }
}