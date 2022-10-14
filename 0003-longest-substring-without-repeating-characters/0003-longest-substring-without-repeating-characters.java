class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int n = s.length();
        int max = 0;
        for(int i = 0; i<n ; i++){
            char in = s.charAt(i);
            
            if(map.containsKey(in)){
                if(map.get(in)>=j)
                    j = map.get(in) +1;
            }
            max = Math.max(max, i-j+1);
            map.put(in, i);
        }
        return max;
    }
}