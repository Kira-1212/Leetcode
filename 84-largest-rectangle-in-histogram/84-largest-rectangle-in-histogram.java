class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)return 0;
        int max = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int i = 0;
        while(i<heights.length){
            if(s.peek() == -1 || heights[i]> heights[s.peek()]){
                s.push(i);
                i++;
                
            }
            else{
                max = Math.max(max, heights[s.pop()] * (i - s.peek() - 1));
            }
            
        }
        while(s.peek() != -1){
            max = Math.max(max, heights[s.pop()] * (i - s.peek() - 1));
        }
        return max;
    }
}