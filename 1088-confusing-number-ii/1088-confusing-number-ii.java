class Solution {
    HashMap<Integer, Integer> map ;
    int count;
    public int confusingNumberII(int n) {
        if(n ==0)return 0;
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9, 6);
        count = 0;
        dfs(n, 0);
        return count;
    }
    private void dfs(int n, long curr){
        if(curr>n)return;
        if(isvalid(curr))count++;
        for(int key : map.keySet()){
            long newNum = curr * 10 +key;
            if(newNum != 0){
                dfs(n,newNum);
            }
        }
    }
    private boolean isvalid(long num){
        long res =0;
        long ini = num;
        while(num>0){
            res = res *10 + map.get((int)(num %10));
            num = num/10;
        }
        return ini != res;
    }
}