class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc ,-1);
        Arrays.fill(lastOcc ,-1);
        int count =0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(firstOcc[c-'a'] == -1)
                firstOcc[c-'a'] = i;
            else
                lastOcc[c-'a'] = i;
        }
        
        for(int i = 0; i<26; i++){
            int si = firstOcc[i];
            int ei = lastOcc[i];
            HashSet<Integer> set = new HashSet<>();
            
            for(int j = si+1; j<ei ;j++){
                if(!set.contains(s.charAt(j) -'a')){
                    set.add(s.charAt(j) -'a');
                    count++;
                }
            }
            
        }
        return count;
    }
}