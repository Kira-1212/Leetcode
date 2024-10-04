class Solution {
    public double myPow(double x, int n) {
        long exp = (long)n;
        if(n==0)
            return 1;
        if(n<0){
            exp = -1 * exp;
            x = 1.0/x;
        }
        double result = 1;
        while(exp!=0){
            if(exp%2 ==1){
                result = result *x;
                exp--;
            }
            x = x*x;
            exp = exp /2;

        }
        return result;
    }
}