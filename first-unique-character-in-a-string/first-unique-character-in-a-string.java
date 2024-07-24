class Solution {
    public int firstUniqChar(String s) {
        if(s== null || s.length() == 0)
            return -1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i= 0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), new ArrayList());
            }
            map.get(s.charAt(i)).add(i);
        }
        
        for(char c: s.toCharArray()){
            if(map.get(c).size() == 1){
                return map.get(c).get(0);
            }
        }
        return -1;
    }
}