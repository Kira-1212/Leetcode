class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length ==0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            if(!map.containsKey(String.valueOf(tempArray)))
                map.put(String.valueOf(tempArray), new ArrayList<>());
            map.get(String.valueOf(tempArray)).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}