class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();
        int c = 0;
        for(int i = 0; i<p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int i = 0;
        while(i<s.length()){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int count = map.get(in);
                count--;
                map.put(in, count);
                if(count == 0)
                    c++;
            }
            
            if(i>=p.length()){
                char out = s.charAt(i -p.length());
                if(map.containsKey(out)){
                    int count = map.get(out);
                    count++;
                    map.put(out, count);
                    if(count == 1)
                        c--;
                }
            }
            if(c==map.size()){
                result.add(i+1-p.length());
            }
            i++;
            
        }
        return result;
    }
}