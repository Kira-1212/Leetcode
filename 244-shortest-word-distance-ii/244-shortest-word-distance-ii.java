class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i =0; i<wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i] , new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i= 0;
        int j =0;
        while(i<l1.size() && j<l2.size()){
            int idx1 = l1.get(i);
            int idx2 = l2.get(j);
            if(idx1<idx2){
                i++;
            }
            else{
                j++;
            }
            min = Math.min(min, Math.abs(idx1-idx2));
        }
        return min;
        
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */