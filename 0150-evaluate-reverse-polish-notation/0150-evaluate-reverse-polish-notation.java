class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String t : tokens){
            if(t.equals("+")){
                int two = (s.pop());
                int one = (s.pop());
                s.push(one+two);
            }
            else if(t.equals("-")){
                int two = (s.pop());
                int one = (s.pop());
                s.push(one-two);
            }
            else if(t.equals("*")){
                int two = (s.pop());
                int one = (s.pop());
                s.push(one*two);
            }
            else if(t.equals("/")){
                int two = (s.pop());
                int one = (s.pop());
                s.push(one/two);
            }
            else{
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
}