class Solution {
    public int trap(int[] height) {
        int l = 0, lw = 0, rw = 0;
        int r = height.length-1;
        int result = 0;
        while(l<=r){
            if(lw<=rw){
                if(lw>height[l]){
                    result+=lw- height[l];
                }
                else
                    lw = height[l];
                
                l++;
            }
            else{
                if(rw>height[r]){
                    result += rw - height[r];
                }
                else
                    rw = height[r];
                r--;
            }
        }
        return result;
    }
}