class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int max = 0;
        int maxC = 0;
        for(int i = 0; i<s.length(); i++){
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
            if(freq[ch]>max){
                max = freq[ch];
                maxC = ch;
            }
        }
        if(max > (s.length() + 1)/2) return "";
        char[] res = new char[s.length()]; 
        int idx = 0;
        while(freq[maxC]>0){
            res[idx] = (char)(maxC + 'a');
            idx+=2;
            freq[maxC]--;
        }
        for(int i = 0; i<freq.length; i++){
            while(freq[i]>0){
                if(idx >=res.length ){
                    idx = 1;
                }
                res[idx]= (char)(i +'a');
                freq[i]--;
                idx+=2;
            }
        }
        return String.valueOf(res);
    }
}