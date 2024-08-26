class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        char[] se = s.toCharArray();
        
        se = reverse(se, 0, se.length-1);
        int low = 0;
        
        for(int i = 0; i<se.length; i++){
            if(se[i] == ' ' ){
                se = reverse(se, low, i-1);
                low = i+1;
            }
        }
        se= reverse(se, low, se.length-1);
        return new String(se);
    }
    public static char[] reverse(char[] s, int l, int h){
        while(l<h){
            char temp = s[l];
            s[l] = s[h];
            s[h] = temp;
            l++;
            h--;
        }
        return s;

    }
}