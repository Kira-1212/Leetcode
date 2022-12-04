class Solution {
    HashSet<Character> set;
    public int maxLength(List<String> arr) {
        set = new HashSet<>();
        
        return backtrack(arr, 0);
    }
    
    private int backtrack(List<String> s, int i){
        if(i == s.size())
            return set.size();
        
        int res = 0;
        
        if(!overlap(s.get(i))){
            for(char c : s.get(i).toCharArray()){
                set.add(c);
            }
                res = backtrack(s, i+1);
            for(char c : s.get(i).toCharArray()){
                set.remove(c);
            }
            
        }
        return Math.max(res, backtrack(s, i+1));
    }
    private boolean overlap(String s){
        
        HashSet<Character> prev = new HashSet();
        for(char c : s.toCharArray()){
            if(set.contains(c) || prev.contains(c))
                return true;
            prev.add(c);
        }
        return false;
    }
}