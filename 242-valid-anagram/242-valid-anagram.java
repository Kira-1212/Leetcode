class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            
        }
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
                return false;
            else{
                int count = map.get(c);
                count--;
                if(count == 0){
                    map.remove(c);
                }
                else{
                    map.put(c,count);
                }
            }
        }
        return map.size() == 0;
    }
}