// class Solution {
//     public String longestPalindrome(String s) {
//         if(s == null || s.length() == 0)return "";
//         int n = s.length();
//         int max =0;
//         int start = 0;
//         int end = 0;
//         boolean[][] dp = new boolean[n][n];
//         for( int i =0; i<n; i++){
//             for(int j =0; j<=i; j++){
//                 if(s.charAt(i) == s.charAt(j) && ((i-j-1 <2) || dp[i-1][j+1])){
//                     dp[i][j] = true;
//                     if(max < i-j+1){
//                         max = i-j+1;
//                         start = j;
//                         end = i;
//                     }
//                 }
//             }
//         }
//         return s.substring(start, end +1);
//     }
// }

class Solution {
    int max =0;
    int start = 0;
    int end = 0;
    int n;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";
        n = s.length();
        
       for(int i = 0; i<n ; i++){
           extend(s, i , i);
           if(i+1<n && s.charAt(i) == s.charAt(i+1)){
               extend(s, i, i+1);
           }
       }
        return s.substring(start, end +1);
    }
    private void extend(String s, int l, int r){
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            
        }
        l++;
        r--;
        if(max<r-l+1){
            max = r-l+1;
            start = l;
            end = r;
        }
    }
}