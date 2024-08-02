class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = getKey(s);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
                
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
    
    private String getKey(String s){
        int[] fre = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            fre[c-'a']++;
        }
        for(int i = 0; i<26; i++){
            if(fre[i] == 0)
                sb.append('#');
            else{
                sb.append(fre[i]);
                sb.append('#');

                
            }
        }
        return sb.toString();
    }
}