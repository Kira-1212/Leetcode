class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures== null || temperatures.length == 0) return new int[]{};
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i =0; i<temperatures.length; i++){
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i]){
                int top = s.pop();
                result[top] = i -top;
            }
            s.push(i);
        }
        return result;
    }
}