class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals("*") )return true;
        int m = p.length();
        int n = s.length();
        
        int sp =0, pp =0;
        int sStar = -1, pStar = -1;
        
        while(sp <n){
            if(pp<m && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')){
                pp++;
                sp++;
            }
            else if(pp<m && p.charAt(pp) == '*'){
                sStar = sp;
                pStar = pp;
                pp++;
            }
            else if(pStar == -1)
                return false;
            else{
                sp = sStar+1;
                pp = pStar+1;
                sStar = sp;
            }
        }
        while(pp<m){
            if(p.charAt(pp)!='*')
                return false;
            pp++;
        }
        return true;
    }
}