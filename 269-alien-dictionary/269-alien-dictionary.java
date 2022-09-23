class Solution {
    int[] indegrees;
    HashMap<Character, List<Character>> map;
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0)return "";
        
        indegrees = new int[26];
        map = new HashMap<>();
        buildGraph(words);
        
        StringBuilder sb = new StringBuilder();
        
        Queue<Character> q = new LinkedList<>();
        
        for( char key : map.keySet()){
            if(indegrees[key-'a'] == 0){
                q.add(key);
                sb.append(key);
            }
        }
        while(!q.isEmpty()){
            char c = q.poll();
            List<Character> li = map.get(c);
            for(char ch : li){
                indegrees[ch-'a']--;
                if(indegrees[ch-'a'] == 0){
                    q.add(ch);
                    sb.append(ch);
                }
            }
        }
        if(sb.length() == map.size())return sb.toString();
        else
            return "";
        
    }
    private void buildGraph(String[] words){
        for(String word : words){
            for( int i =0; i<word.length();i++){
                if(!map.containsKey(word.charAt(i))){
                    map.put(word.charAt(i), new ArrayList<>());
                }
            }
        }
        for(int i = 0; i<words.length-1; i++){
            String f = words[i];
            String s = words[i+1];
            int m = f.length();
            int n = s.length();
            if(m>n && f.startsWith(s)){
                map.clear();
                return;
            }
            for(int j = 0; j<m && j<n ; j++){
                char first = f.charAt(j);
                char second = s.charAt(j);
                if(first != second){
                    map.get(first).add(second);
                    indegrees[second-'a']++;
                    break;
                }
            }
            
            
            
        }
    }
}