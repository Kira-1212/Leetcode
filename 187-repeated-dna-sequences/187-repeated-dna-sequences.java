class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> hset = new HashSet<>();
        for(int i = 0 ; i<=s.length()-10; i++){
            String temp = s.substring(i, i+10);
            if(set.contains(temp))
                hset.add(temp);
            set.add(temp);
            
        }
        List<String> result = new ArrayList<>();
        for(String r : hset){
            result.add(r);
        }
        return result;
    }
}