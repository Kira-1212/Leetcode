class Solution {
    public String customSortString(String order, String s) {
        if(s.length() == 0 || s == null)return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            while(map.getOrDefault(c, 0) > 0){
                sb.append(c);
                map.put(c, map.get(c) -1);

            }
        }

        for( char c : map.keySet()){
            int count = map.get(c);
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}