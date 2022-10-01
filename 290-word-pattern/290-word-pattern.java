class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> pmap = new HashMap<>();
        HashMap<String,Character> smap = new HashMap<>();
        String[] sArr = s.split(" ");
        if(pattern.length() != sArr.length)return false;
        for(int i =0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String curr = sArr[i];
            if(pmap.containsKey(c) && !pmap.get(c).equals(curr))
                return false;
            else
                pmap.put(c, curr);
            
            if(smap.containsKey(curr) && smap.get(curr)!= c)
                return false;
            else
                smap.put(curr, c);
            
        }
        
        return true;
    }
}