class Solution {
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int rem = 0;
        while(n != 1){
            res = 0;
            rem = 0;
            while(n>0){
                rem = n % 10;
                n = n/10;
                res = res + rem * rem;
            }
            if(set.contains(res))
                return false;
            set.add(res);
            n = res;
            
        }
        return true;
    }
}