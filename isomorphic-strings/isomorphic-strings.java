class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Character> smap= new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){
            if(!smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i), t.charAt(i));
            }
            else{
                if(smap.get(s.charAt(i)) != t.charAt(i))
                   return false;
            }
            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i), s.charAt(i));
            }
            else{
                if(tmap.get(t.charAt(i)) != s.charAt(i))
                   return false;
            }
        }
        return true;
    }
}