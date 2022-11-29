class Solution {
    List<List<Integer>> result;
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) +1);
        n = nums.length;
        backtrack(count, new ArrayList<>());
        return result;
    }
    private void backtrack(HashMap<Integer,Integer> count, List<Integer> path){
        if(path.size() == n){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int key: count.keySet()){
            if(count.get(key)>0){
                path.add(key);
                count.put(key, count.get(key)-1);
                
                backtrack(count, path);
                count.put(key, count.get(key)+1);
                path.remove(path.size()-1);
                
            }
        }
        
    }
}