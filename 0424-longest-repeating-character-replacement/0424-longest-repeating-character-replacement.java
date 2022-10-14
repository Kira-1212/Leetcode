class Solution {
    public int characterReplacement(String s, int k) {
        int j = 0;
        int maxF = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c));
            while((i-j+1)- maxF>k){
                char out = s.charAt(j);
                map.put(out, map.get(out) - 1);
                j++;
            }
            res = Math.max(res, i-j+1);
        }
        return res;
    }
}