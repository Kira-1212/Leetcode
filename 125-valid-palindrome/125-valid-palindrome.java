class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            while(l<s.length() && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while(r>0 && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            if(l<s.length() && r>0 && Character.toLowerCase(s.charAt(r)) != Character.toLowerCase(s.charAt(l)))
                return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }
}