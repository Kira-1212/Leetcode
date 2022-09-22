class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        if(queries == null || queries.length ==0)return new ArrayList<>();
        List<Boolean> result = new ArrayList<>();
        
        for(String s : queries){
            int i =0;
            boolean match = false;
            for(int j =0; j<s.length(); j++){
                if(i<pattern.length() && pattern.charAt(i) == s.charAt(j)){
                    i++;
                    if(i == pattern.length())
                        match = true;
                }
                else if(Character.isUpperCase(s.charAt(j))){
                    match = false;
                    break;
                }
            }
            result.add(match);
        }
        return result;
    }
}