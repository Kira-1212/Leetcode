class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null)return 0;
        s= s.trim();
        String[] str = s.split(" ");
        return str[str.length-1].length();
    }
}