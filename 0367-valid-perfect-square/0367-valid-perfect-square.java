class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2)
            return true;
        long left = 2, right = num/2;
        while(left<=right){
            long x = left + (right- left)/2;
            long sq = x * x;
            if(sq == num)
                return true;
            if(sq>num){
                right = x-1;
            }
            else
                left = x+1;
        }
        return false;
    }
}