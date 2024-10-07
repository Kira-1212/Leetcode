class Solution {
    public boolean isPalindrome(String s) {
        if(s == "" && s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while(l<=r){
        
            while(l<r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while(l<r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            if(l<s.length() && r>0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            else{
                l++;
                r--;
            }
        }
        return true;

    }
}