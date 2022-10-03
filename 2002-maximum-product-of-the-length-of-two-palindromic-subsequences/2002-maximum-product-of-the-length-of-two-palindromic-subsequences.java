class Solution {
    int max = Integer.MIN_VALUE;
    public int maxProduct(String s) {
        
        dfs(s, 0, new StringBuilder(), new StringBuilder());
        
        return max;
    }
    private void dfs(String s, int i, StringBuilder s1, StringBuilder s2){
        if(i>=s.length()){
            if(isPalin(s1.toString()) &&isPalin(s2.toString())){
                max = Math.max(max, s1.length() * s2.length());  
                
            }
            return;
        }
        
        s1.append(s.charAt(i));
        dfs(s, i+1, s1, s2);
        s1.setLength(s1.length()-1);
        s2.append(s.charAt(i));
        dfs(s, i+1, s1, s2);
        s2.setLength(s2.length()-1);
        dfs(s, i+1, s1, s2);
        
    }
    private boolean isPalin(String s){
        int l = 0;
        int r = s.length()-1;
        
        while(l<=r){
            if(s.charAt(l)!= s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}