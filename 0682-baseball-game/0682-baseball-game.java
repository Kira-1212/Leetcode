class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        
        for(String op : operations){
            if(op.equals("+")){
                int one = 0, two = 0;
                if(!s.isEmpty()){
                    two = s.pop();
                    
                }
                if(!s.isEmpty()){
                    one = s.pop();
                    
                }
                int three = one + two;
                s.push(one);
                s.push(two);
                s.push(three);
            }
            else if(op.equals("C")){
                if(!s.isEmpty()){
                    s.pop();
                    
                }
            }
            else if(op.equals("D")){
                int temp = 0;
                if(!s.isEmpty()){
                    temp = s.pop();
                }
                s.push(temp);
                s.push(temp * 2);
            }
            else{
                s.push(Integer.parseInt(op));
            }
        }
        int result = 0;
        while(!s.isEmpty())
            result += s.pop();
        return result;
    }
}