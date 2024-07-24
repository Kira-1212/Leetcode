class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<list1.length; i++){
            map.put(list1[i], i);
        }
        HashMap<Integer, List<String>> indexMap = new HashMap<>();
        for(int i = 0; i<list2.length; i++){
            if(map.containsKey(list2[i])){
                int index = map.get(list2[i]) + i;
                if(!indexMap.containsKey(index)){
                    indexMap.put(index, new ArrayList<>());
                }
                indexMap.get(index).add(list2[i]);
                min = Math.min(min, index);
            }
        }
        
        List<String> res = indexMap.get(min);
        String[] result = new String[res.size()];
        int i = 0;
        for(String s: res)
            result[i++] = s;
        return result;
    }
}