class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null )return true;
        
        int p1 = 0;
        int p2 = 0;
        int m = s.length();
        int n = t.length();
        while(p1<m && p2<n){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
            }
            else{
                p2++;
            }
        }
        return p1 == m;
    }
}