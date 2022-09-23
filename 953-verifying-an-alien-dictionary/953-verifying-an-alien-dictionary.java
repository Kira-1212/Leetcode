class Solution {
     HashMap<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length == 0)return true;
        
        
        map = new HashMap<>();
        for( int i =0; i<order.length(); i++){
            map.put(order.charAt(i), i+1);
        }
        
        for( int i =0; i<words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            if(isNotSorted(first,second))
                return false;
        }
        return true;
    }
    
    private boolean isNotSorted(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int i = 0;
        int j =0;
        while(i <m && i<n){
            if(s1.charAt(i) != s2.charAt(i)){
                return (map.get(s1.charAt(i))>map.get(s2.charAt(i)));

            }
            i++;

        }
        return m>n;
    }
}