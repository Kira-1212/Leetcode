// class Solution {
//     public int lengthOfLastWord(String s) {
//         if(s == null)return 0;
//         s= s.trim();
//         String[] str = s.split(" ");
//         return str[str.length-1].length();
//     }
// }


class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null)return 0;
        int n = s.length();
        int length = 0;
        while(n>0){
            n--;
            if(s.charAt(n)!=' '){
                length++;
            }
            else if(length>0)
                return length;
        }
        
        return length;
    }
}