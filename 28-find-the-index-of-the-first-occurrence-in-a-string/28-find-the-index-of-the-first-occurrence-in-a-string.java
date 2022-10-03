class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 || needle.length() == 0)
            return -1;
        
        int j = 0;
        String result = "";
        for(int i = 0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(i + needle.length() <= haystack.length())
                    result = haystack.substring(i, i+needle.length());
                else
                    return -1;
            }
            if(needle.equals(result))
                return i;
            
        }
        return  -1;
    }
}