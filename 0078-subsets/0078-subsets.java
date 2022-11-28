class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, 0 , new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> path){
        
            result.add(new ArrayList<>(path));

        for(int i = index; i<nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
        
    }
}