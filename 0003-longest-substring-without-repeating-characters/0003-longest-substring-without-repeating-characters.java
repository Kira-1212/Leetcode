class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int n = s.length();
        int max = 0;
        for(int i = 0; i<n ; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.get(c)>1){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}