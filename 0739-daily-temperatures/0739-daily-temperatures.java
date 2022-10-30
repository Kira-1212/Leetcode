class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[temperatures.length];
        s.push(temperatures.length-1);
        
        for(int i = temperatures.length-2; i>=0; i--){
            while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();

            }
            if(!s.isEmpty())
                result[i] = s.peek() - i;
            
            s.push(i);
            
        }
        return result;
    }
}