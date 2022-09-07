class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() ==0 || t.length() == 0)return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int match = 0;
        int min = Integer.MAX_VALUE;
        int i = 0; int j = 0;
        String out = "";
        while(i<=j && i<s.length()){
            if(match == map.size()){
                min = Math.min(min, j-i);
                if(min == j-i){
                    out = s.substring(i, j);
                }
            }
            if((i !=j && match==map.size()) || j == s.length()){
                char o = s.charAt(i);
                if(map.containsKey(o)){
                    int count = map.get(o);
                    if(count ==0){
                        match--;
                    }
                    map.put(o,count+1);
                }
                i++;
            }
            else{
                char in = s.charAt(j);
                if(map.containsKey(in)){
                    int count = map.get(in);
                    if(count == 1){
                        match++;
                    }
                    map.put(in, count -1);
                }
                j++;
            }
        }
        return out;
    }
}