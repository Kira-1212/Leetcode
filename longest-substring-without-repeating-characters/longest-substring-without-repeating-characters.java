class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for(int i = 0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)+1>=j)
                    j = map.get(c)+1;
            }
            res = Math.max(res, i-j+1);
            map.put(c, i);
        }
        return res;
    }
}